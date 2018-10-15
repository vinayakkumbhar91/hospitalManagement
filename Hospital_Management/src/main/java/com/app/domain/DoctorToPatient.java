package com.app.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DoctorToPatient {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Doctor doctor;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Patient patient;

	@Override
	public String toString() {
		return "DoctorToPatient [id=" + id + ", doctor=" + doctor + ", patient=" + patient + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
