package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.domain.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public int saveAdmin(Admin admin) {
		return (Integer) openSession().save(admin);
	}

	public int updateAdmin(Admin admin) {
		openSession().update(admin);
		return admin.getId();
	}

	public Admin getAdminById(int id) {
		return (Admin) openSession().get(Admin.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmin() {
		return openSession().createQuery("from Admin").list();
	}

	public void deleteAdminById(int id) {
		Admin admin = getAdminById(id);
		openSession().delete(admin);
	}

	@SuppressWarnings("unchecked")
	public List<Admin> searchAdmins(String option) {
		String hql = "from Admin where firstName like '%" + option + "%' or emailId like '%" + option
				+ "%' or mobile  like '%" + option + "%' or status like '%" + option + "%'";
		return openSession().createQuery(hql).list();
	}

	public void changeStatus(Admin Admin) {
		openSession().update(Admin);
	}

}
