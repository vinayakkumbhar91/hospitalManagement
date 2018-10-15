package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.MedicineCatagoryDao;
import com.app.domain.MedicineCatagory;

@EnableTransactionManagement
@Service
public class MedicineCatagoryServiceImpl implements MedicineCatagoryService {

	@Autowired
	private MedicineCatagoryDao medicineCatagoryDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int addMedicineCatagory(MedicineCatagory medicineCatagoty) {
		return medicineCatagoryDao.addMedicineCatagory(medicineCatagoty);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateMedicineCatagory(MedicineCatagory medicineCatagory) {
		medicineCatagoryDao.updateMedicineCatagory(medicineCatagory);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateMedicineCtagory(MedicineCatagory medicineCatagory) {
		medicineCatagoryDao.updateMedicineCatagory(medicineCatagory);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteMedicineCatagoryById(int id) {
		medicineCatagoryDao.deleteMedicineCatagoryById(id);
	}

	@Transactional(readOnly = true)
	public MedicineCatagory getMedicineCatagoryById(int id) {
		return medicineCatagoryDao.getMedicineCatagoryById(id);
	}

	@Transactional(readOnly = true)
	public List<MedicineCatagory> getAllMedicineCatagory() {
		return medicineCatagoryDao.getAllMedicineCatagory();
	}

	@Transactional(readOnly = true)
	public List<MedicineCatagory> searchMedicineCatagory(String option) {
		return medicineCatagoryDao.searchMedicineCatagory(option);
	}
}
