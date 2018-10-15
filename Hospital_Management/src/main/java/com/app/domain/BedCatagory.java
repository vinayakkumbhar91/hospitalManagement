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
public class BedCatagory {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String bedCatagoryName;
	private boolean status;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Bed> beds;

	@Override
	public String toString() {
		return "BedCatagory [id=" + id + ", bedCatagoryName=" + bedCatagoryName + ", status=" + status + ", beds="
				+ beds + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBedCatagoryName() {
		return bedCatagoryName;
	}

	public void setBedCatagoryName(String bedCatagoryName) {
		this.bedCatagoryName = bedCatagoryName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

}
