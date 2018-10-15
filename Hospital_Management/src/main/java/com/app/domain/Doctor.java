package com.app.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctor {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String userId;
	private Long mobile;
	@JsonIgnore
	private String password;
	private boolean status;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "doctor")
	private List<DoctorToPatient> doctopat;

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userId=" + userId + ", mobile=" + mobile + ", password=" + password + ", status=" + status
				+ ", doctopat=" + doctopat + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public List<DoctorToPatient> getDoctopat() {
		return doctopat;
	}

	public void setDoctopat(List<DoctorToPatient> doctopat) {
		this.doctopat = doctopat;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}