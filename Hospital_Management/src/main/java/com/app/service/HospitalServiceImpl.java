package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.HospitalDao;
import com.app.domain.Hospital;
@EnableTransactionManagement
@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int saveHospital(Hospital hospital) {
		return hospitalDao.saveHospital(hospital);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateHospital(Hospital hospital) {
		return hospitalDao.updateHospital(hospital);
	}

	@Transactional(readOnly=true)
	public Hospital getHospitalById(int id) {
		return hospitalDao.getHospitalById(id);
	}

	@Transactional(readOnly=true)
	public List<Hospital> getAllHospital() {
		return hospitalDao.getAllHospital();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteHospitalById(int id) {
		hospitalDao.deleteHospitalById(id);
	}
	
	@Transactional(readOnly=true)
	public List<Hospital> searchHospitals(String option) {
		return hospitalDao.searchHospitals(option);	
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void changeStatus(Hospital hospital) {
		hospitalDao.changeStatus(hospital);
	}
}
