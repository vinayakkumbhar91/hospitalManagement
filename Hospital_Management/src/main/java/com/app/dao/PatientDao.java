package com.app.dao;

import java.util.List;

import com.app.domain.Patient;

public interface PatientDao {
	public int savePatient(Patient patient);
	public int updatePatient(Patient patient); 
	public Patient getPatientById(int id);
	public List<Patient> getAllPatient();
	public void deletePatientById(int id);
	public List<Patient> searchPatients(String option);
	public void changeStatus(Patient patient);
	public void assignDoctor(int docId,int patId);
	public void unassingDoctor(int docId,int patId);
}
