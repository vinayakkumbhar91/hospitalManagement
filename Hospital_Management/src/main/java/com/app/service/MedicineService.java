package com.app.service;

import java.util.List;

import com.app.domain.Medicine;

public interface MedicineService {

	public int addMedicine(Medicine medicine);

	public void updateMedicine(Medicine medicine);

	public void deleteMedicineById(int id);

	public Medicine getMedicineById(int id);

	public List<Medicine> getAllMedicine();

	public List<Medicine> searchMedicine(String option);
}
