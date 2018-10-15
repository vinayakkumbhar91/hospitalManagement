package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.domain.Bed;

@Repository
public class BedDaoImpl implements BedDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public int addBed(Bed bed) {
		return (Integer) openSession().save(bed);
	}

	public void updateBed(Bed Bed) {
		openSession().update(Bed);
	}

	public void deleteBedById(int id) {
		openSession().delete(getBedById(id));

	}

	public Bed getBedById(int id) {
		return (Bed) openSession().get(Bed.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Bed> getAllBed() {
		return openSession().createQuery("from Bed").list();
	}

	@SuppressWarnings("unchecked")
	public List<Bed> searchBed(String option) {
		return openSession()
				.createQuery("from Bed where bedName like '%" + option + "%' or status like '%" + option + "%'").list();
	}

}
