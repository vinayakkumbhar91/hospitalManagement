package com.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.domain.MedicineCatagory;

@Repository
public class MedicineCatagoryDaoImpl implements MedicineCatagoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public int addMedicineCatagory(MedicineCatagory medicineCatagoty) {
		return (Integer) openSession().save(medicineCatagoty);
	}

	public void updateMedicineCatagory(MedicineCatagory medicineCatagory) {
		openSession().update(medicineCatagory);
	}

	public void deleteMedicineCatagoryById(int id) {
		openSession().delete(getMedicineCatagoryById(id));
	}

	public MedicineCatagory getMedicineCatagoryById(int id) {
		return (MedicineCatagory) openSession().get(MedicineCatagory.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<MedicineCatagory> getAllMedicineCatagory() {
		return openSession().createCriteria(MedicineCatagory.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<MedicineCatagory> searchMedicineCatagory(String option) {
		Query query = openSession().createQuery("from MedicineCatagory where medicineCatagoryName like '%" + option
				+ "%' or medicineCatagoryStatus like '%" + option + "%'");
		return query.list();
	}

}
