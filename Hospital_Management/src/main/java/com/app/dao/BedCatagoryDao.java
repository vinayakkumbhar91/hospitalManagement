package com.app.dao;

import java.util.List;

import com.app.domain.BedCatagory;

public interface BedCatagoryDao {

	public int addBedCatagory(BedCatagory bedCatagoty);

	public void updateBedCatagory(BedCatagory bedCatagory);

	public void deleteBedCatagoryById(int id);

	public BedCatagory getBedCatagoryById(int id);

	public List<BedCatagory> getAllBedCatagory();

	public List<BedCatagory> searchBedCatagory(String option);
}
