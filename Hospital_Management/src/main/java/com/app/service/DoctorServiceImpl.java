package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DoctorDao;
import com.app.domain.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao DoctorDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int saveDoctor(Doctor Doctor) {
		return DoctorDao.saveDoctor(Doctor);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateDoctor(Doctor Doctor) {
		return DoctorDao.updateDoctor(Doctor);
	}

	@Transactional(readOnly = true)
	public Doctor getDoctorById(int id) {
		return DoctorDao.getDoctorById(id);
	}

	@Transactional(readOnly = true)
	public List<Doctor> getAllDoctor() {
		return DoctorDao.getAllDoctor();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteDoctorById(int id) {
		DoctorDao.deleteDoctorById(id);
	}

	@Transactional(readOnly = true)
	public List<Doctor> searchDoctors(String option) {
		return DoctorDao.searchDoctors(option);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void changeStatus(Doctor Doctor) {
		DoctorDao.changeStatus(Doctor);
	}

}
