package com.app.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MedicineCatagory {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String medicineCatagoryName;
	private boolean medicineCatagoryStatus;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Medicine> medicineList;

	@Override
	public String toString() {
		return "MedicineCatagory [id=" + id + ", medicineCatagoryName=" + medicineCatagoryName
				+ ", medicineCatagoryStatus=" + medicineCatagoryStatus + ", medicineList=" + medicineList + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicineCatagoryName() {
		return medicineCatagoryName;
	}

	public void setMedicineCatagoryName(String medicineCatagoryName) {
		this.medicineCatagoryName = medicineCatagoryName;
	}

	public boolean isMedicineCatagoryStatus() {
		return medicineCatagoryStatus;
	}

	public void setMedicineCatagoryStatus(boolean medicineCatagoryStatus) {
		this.medicineCatagoryStatus = medicineCatagoryStatus;
	}

	public List<Medicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<Medicine> medicineList) {
		this.medicineList = medicineList;
	}

}
