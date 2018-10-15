package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.PatientDao;
import com.app.domain.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int savePatient(Patient patient) {
		return patientDao.savePatient(patient);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updatePatient(Patient patient) {
		return patientDao.updatePatient(patient);
	}

	@Transactional(readOnly = true)
	public Patient getPatientById(int id) {
		return patientDao.getPatientById(id);
	}

	@Transactional(readOnly = true)
	public List<Patient> getAllPatient() {
		return patientDao.getAllPatient();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deletePatientById(int id) {
		patientDao.deletePatientById(id);
	}

	@Transactional(readOnly = true)
	public List<Patient> searchPatients(String option) {
		return patientDao.searchPatients(option);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void changeStatus(Patient patient) {
		patientDao.changeStatus(patient);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void assignDoctor(int docId, int patId) {
		patientDao.assignDoctor(docId, patId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void unassingDoctor(int docId, int patId) {
		patientDao.unassingDoctor(docId, patId);
	}
}
