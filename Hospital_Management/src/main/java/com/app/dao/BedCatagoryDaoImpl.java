package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.domain.BedCatagory;

@Repository
public class BedCatagoryDaoImpl implements BedCatagoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public int addBedCatagory(BedCatagory bedCatagoty) {
		return (Integer) openSession().save(bedCatagoty);
	}

	public void updateBedCatagory(BedCatagory bedCatagory) {
		openSession().update(bedCatagory);
	}

	public void deleteBedCatagoryById(int id) {
		openSession().delete(getBedCatagoryById(id));

	}

	public BedCatagory getBedCatagoryById(int id) {
		return (BedCatagory) openSession().get(BedCatagory.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<BedCatagory> getAllBedCatagory() {
		return openSession().createQuery("from BedCatagory").list();
	}

	@SuppressWarnings("unchecked")
	public List<BedCatagory> searchBedCatagory(String option) {
		return openSession().createQuery(
				"from BedCatagory where bedCatagoryName like '%" + option + "%' or status like '%" + option + "%'")
				.list();
	}

}
