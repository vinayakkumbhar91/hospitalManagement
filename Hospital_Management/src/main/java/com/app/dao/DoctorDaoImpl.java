package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.domain.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public int saveDoctor(Doctor Doctor) {
		return (Integer) openSession().save(Doctor);
	}

	public int updateDoctor(Doctor Doctor) {
		openSession().update(Doctor);
		return Doctor.getId();
	}

	public Doctor getDoctorById(int id) {
		return (Doctor) openSession().get(Doctor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Doctor> getAllDoctor() {
		return openSession().createQuery("from Doctor").list();
	}

	public void deleteDoctorById(int id) {
		Doctor Doctor = getDoctorById(id);
		openSession().delete(Doctor);
	}

	@SuppressWarnings("unchecked")
	public List<Doctor> searchDoctors(String option) {
		String hql = "from Doctor where firstName like '%" + option + "%' or emailId like '%" + option
				+ "%' or mobile  like '%" + option + "%' or status like '%" + option + "%'";
		return openSession().createQuery(hql).list();
	}

	public void changeStatus(Doctor Doctor) {
		openSession().update(Doctor);
	}

}
