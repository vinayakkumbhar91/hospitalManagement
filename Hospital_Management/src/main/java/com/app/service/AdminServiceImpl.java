package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDao;
import com.app.domain.Admin;

@EnableTransactionManagement
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public int saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}

	@Transactional(readOnly = true)
	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);
	}

	@Transactional(readOnly = true)
	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAdminById(int id) {
		adminDao.deleteAdminById(id);
	}

	@Transactional(readOnly = true)
	public List<Admin> searchAdmins(String option) {
		return adminDao.searchAdmins(option);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void changeStatus(Admin Admin) {
		adminDao.changeStatus(Admin);
	}
}
