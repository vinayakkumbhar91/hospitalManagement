package com.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String medicineName;
	private boolean medicineStatus;

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", medicineName=" + medicineName + ", medicineStatus=" + medicineStatus + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public boolean isMedicineStatus() {
		return medicineStatus;
	}

	public void setMedicineStatus(boolean medicineStatus) {
		this.medicineStatus = medicineStatus;
	}

}
