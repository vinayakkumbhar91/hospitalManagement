package com.app.dao;

import java.util.List;

import com.app.domain.MedicineCatagory;

public interface MedicineCatagoryDao {

	public int addMedicineCatagory(MedicineCatagory medicineCatagoty);

	public void updateMedicineCatagory(MedicineCatagory medicineCatagory);

	public void deleteMedicineCatagoryById(int id);

	public MedicineCatagory getMedicineCatagoryById(int id);

	public List<MedicineCatagory> getAllMedicineCatagory();

	public List<MedicineCatagory> searchMedicineCatagory(String option);
}
