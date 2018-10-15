package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BedCatagoryDao;
import com.app.domain.BedCatagory;

@EnableTransactionManagement
@Service
public class BedCatagoryServiceImpl implements BedCatagoryService {

	@Autowired
	private BedCatagoryDao bedCatagoryDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int addBedCatagory(BedCatagory bedCatagoty) {
		return bedCatagoryDao.addBedCatagory(bedCatagoty);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBedCatagory(BedCatagory bedCatagory) {
		bedCatagoryDao.updateBedCatagory(bedCatagory);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteBedCatagoryById(int id) {
		bedCatagoryDao.deleteBedCatagoryById(id);
	}

	@Transactional(readOnly = true)
	public BedCatagory getBedCatagoryById(int id) {
		return bedCatagoryDao.getBedCatagoryById(id);
	}

	@Transactional(readOnly = true)
	public List<BedCatagory> getAllBedCatagory() {
		return bedCatagoryDao.getAllBedCatagory();
	}

	@Transactional(readOnly = true)
	public List<BedCatagory> searchBedCatagory(String option) {
		return bedCatagoryDao.searchBedCatagory(option);
	}

}
