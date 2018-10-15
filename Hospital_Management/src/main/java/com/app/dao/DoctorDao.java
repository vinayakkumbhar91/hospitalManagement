package com.app.dao;

import java.util.List;

import com.app.domain.Doctor;

public interface DoctorDao {
	
	public int saveDoctor(Doctor Doctor);
	public int updateDoctor(Doctor Doctor); 
	public Doctor getDoctorById(int id);
	public List<Doctor> getAllDoctor();
	public void deleteDoctorById(int id);
	public List<Doctor> searchDoctors(String option);
	public void changeStatus(Doctor Doctor);
}
