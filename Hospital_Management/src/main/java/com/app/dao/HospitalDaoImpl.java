package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.domain.Hospital;

@Repository
public class HospitalDaoImpl implements HospitalDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public int saveHospital(Hospital hospital) {
		return (Integer) openSession().save(hospital);
	}

	public int updateHospital(Hospital hospital) {
		openSession().update(hospital);
		return hospital.getId();
	}

	public Hospital getHospitalById(int id) {
		return (Hospital) openSession().get(Hospital.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Hospital> getAllHospital() {
		return openSession().createQuery("from Hospital h").list();
	}
	
	public void deleteHospitalById(int id) {
		openSession().delete(getHospitalById(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<Hospital> searchHospitals(String option) {
		String hql = "select * from Hospital where name like '%"+option+"%' or email like '%"+option+"%' or phoneNo like '%"+option+"%' or status like '%"+option+"%'";
		return openSession().createSQLQuery(hql).addEntity(Hospital.class).list();
	}
	
	public void changeStatus(Hospital hospital) {
		openSession().update(hospital);
	}
}
