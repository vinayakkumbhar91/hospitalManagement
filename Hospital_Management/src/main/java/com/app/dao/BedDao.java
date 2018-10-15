package com.app.dao;

import java.util.List;

import com.app.domain.Bed;

public interface BedDao {

	public int addBed(Bed bed);

	public void updateBed(Bed Bed);

	public void deleteBedById(int id);

	public Bed getBedById(int id);

	public List<Bed> getAllBed();

	public List<Bed> searchBed(String option);
}
