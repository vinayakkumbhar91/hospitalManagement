package com.app.service;

import java.util.List;

import com.app.domain.Admin;

public interface AdminService {

	public int saveAdmin(Admin admin);
	public int updateAdmin(Admin admin);
	public Admin getAdminById(int id);
	public List<Admin> getAllAdmin();
	public void deleteAdminById(int id);
	public List<Admin> searchAdmins(String option);
	public void changeStatus(Admin Admin);
}
