package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BedDao;
import com.app.domain.Bed;

@EnableTransactionManagement
@Service
public class BedServiceImpl implements BedService {

	@Autowired
	private BedDao bedDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int addBed(Bed bed) {
		return bedDao.addBed(bed);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBed(Bed bed) {
		bedDao.updateBed(bed);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteBedById(int id) {
		bedDao.deleteBedById(id);
	}

	@Transactional(readOnly = true)
	public Bed getBedById(int id) {
		return bedDao.getBedById(id);
	}

	@Transactional(readOnly = true)
	public List<Bed> getAllBed() {
		return bedDao.getAllBed();
	}

	@Transactional(readOnly = true)
	public List<Bed> searchBed(String option) {
		return bedDao.searchBed(option);
	}

}
