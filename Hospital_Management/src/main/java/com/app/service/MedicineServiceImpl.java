package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.MedicineDao;
import com.app.domain.Medicine;

@EnableTransactionManagement
@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int addMedicine(Medicine medicine) {
		return medicineDao.addMedicine(medicine);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateMedicine(Medicine medicine) {
		medicineDao.updateMedicine(medicine);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateMedicineCtagory(Medicine medicine) {
		medicineDao.updateMedicine(medicine);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteMedicineById(int id) {
		medicineDao.deleteMedicineById(id);
	}

	@Transactional(readOnly = true)
	public Medicine getMedicineById(int id) {
		return medicineDao.getMedicineById(id);
	}

	@Transactional(readOnly = true)
	public List<Medicine> getAllMedicine() {
		return medicineDao.getAllMedicine();
	}

	@Transactional(readOnly = true)
	public List<Medicine> searchMedicine(String option) {
		return medicineDao.searchMedicine(option);
	}
}
