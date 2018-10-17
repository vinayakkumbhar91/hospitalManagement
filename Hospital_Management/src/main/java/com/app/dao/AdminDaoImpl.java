package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.domain.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	private static final Logger logger = Logger.getLogger(AdminDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		logger.debug("session object created and return");
		return sessionFactory.getCurrentSession();
	}

	public int saveAdmin(Admin admin) {
		logger.debug("In save admin method");
		try {
			logger.info("admin object saved");
			return (Integer) openSession().save(admin);
		} catch (Exception e) {
			logger.error("error during saving an Admin");
			return 0;
		}
	}

	public int updateAdmin(Admin admin) {
		logger.debug("In update admin method");
		try {
			logger.info("admin data updated");
			openSession().update(admin);
			return admin.getId();
		} catch (Exception e) {
			logger.error("error during updating an Admin");
			return 0;
		}

	}

	public Admin getAdminById(int id) {
		logger.debug("In admin getAdminById method");
		try {
			logger.info("admin data got and return");
			return (Admin) openSession().get(Admin.class, id);
		} catch (Exception e) {
			logger.error("error during geting admin data by id return null");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmin() {
		logger.debug("In admin getAllAdmin method");
		try {
			logger.info("got all admin data  and return");
			return openSession().createQuery("from Admin").list();
		} catch (Exception e) {
			logger.error("error during geting Alladmin  return null");
			return null;
		}

	}

	public void deleteAdminById(int id) {
		logger.debug("In admin deleteAdminById method");
		try {
			Admin admin = getAdminById(id);
			openSession().delete(admin);
			logger.info(" admin data deleted");
		} catch (Exception e) {
			logger.error("error during deleting admin data");
		}

	}

	@SuppressWarnings("unchecked")
	public List<Admin> searchAdmins(String option) {
		logger.debug("In adminDao  searchAdmins method");
		String hql = "from Admin where firstName like '%" + option + "%' or emailId like '%" + option
				+ "%' or mobile  like '%" + option + "%' or status like '%" + option + "%'";
		try {
			logger.info("data search and return");
			return openSession().createQuery(hql).list();
		} catch (Exception e) {
			logger.error("error during search operation return null");
			return null;
		}

	}

	public void changeStatus(Admin Admin) {
		logger.debug("In admin dao change status method");
		try {
			logger.info("admin status updated");
			openSession().update(Admin);
		} catch (Exception e) {
			logger.info("admin status not updated");
		}

	}

}
