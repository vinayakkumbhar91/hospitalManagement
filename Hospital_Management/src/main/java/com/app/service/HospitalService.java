package com.app.service;

import java.util.List;

import com.app.domain.Hospital;

public interface HospitalService {

	public int saveHospital(Hospital hospital);
	public int updateHospital(Hospital hospital);
	public Hospital getHospitalById(int id);
	public List<Hospital> getAllHospital();
	public void deleteHospitalById(int id);
	public List<Hospital> searchHospitals(String option);
	public void changeStatus(Hospital hospital);
}
