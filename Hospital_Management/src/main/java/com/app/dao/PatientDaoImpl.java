package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.domain.Doctor;
import com.app.domain.DoctorToPatient;
import com.app.domain.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public int savePatient(Patient patient) {
		return (Integer) openSession().save(patient);
	}

	public int updatePatient(Patient patient) {
		openSession().update(patient);
		return patient.getId();
	}

	public Patient getPatientById(int id) {
		return (Patient) openSession().get(Patient.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Patient> getAllPatient() {
		return openSession().createQuery("from Patient").list();
	}

	public void deletePatientById(int id) {
		Patient patient = getPatientById(id);
		openSession().delete(patient);
	}

	@SuppressWarnings("unchecked")
	public List<Patient> searchPatients(String option) {
		String hql = "from Patient where firstName like '%" + option + "%' or emailId like '%" + option
				+ "%' or mobile  like '%" + option + "%' or status like '%" + option + "%'";
		return openSession().createQuery(hql).list();
	}

	public void changeStatus(Patient patient) {
		openSession().update(patient);
	}

	public void assignDoctor(int docId, int patId) {
		Doctor doctor = (Doctor) openSession().get(Doctor.class, docId);
		Patient patient = (Patient) openSession().get(Patient.class, patId);
		List<DoctorToPatient> doctopat = new ArrayList<DoctorToPatient>();
		DoctorToPatient dtp = new DoctorToPatient();
		dtp.setDoctor(doctor);
		dtp.setPatient(patient);
		doctopat.add(dtp);
		patient.setDoctopat(doctopat);
		openSession().update(patient);
	}

	public void unassingDoctor(int docId, int patId) {
		Query query = openSession()
				.createQuery("delete from DoctorToPatient where doctor_id=:docid and patient_id=:patid");
		query.setParameter("docid", docId);
		query.setParameter("patid", patId);
		query.executeUpdate();
	}
}
