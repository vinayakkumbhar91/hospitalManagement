package com.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.domain.Medicine;

@Repository
public class MedicineDaoImpl implements MedicineDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public int addMedicine(Medicine medicine) {
		return (Integer) openSession().save(medicine);
	}

	public void updateMedicine(Medicine medicine) {
		openSession().update(medicine);
	}

	public void deleteMedicineById(int id) {
		openSession().delete(getMedicineById(id));
	}

	public Medicine getMedicineById(int id) {
		return (Medicine) openSession().get(Medicine.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Medicine> getAllMedicine() {
		return openSession().createCriteria(Medicine.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Medicine> searchMedicine(String option) {
		Query query = openSession().createQuery(
				"from Medicine where medicineName like '%" + option + "%' or medicineStatus like '%" + option + "%'");
		return query.list();
	}
}
