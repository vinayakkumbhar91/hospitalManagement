package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.Admin;
import com.app.domain.Hospital;
import com.app.service.AdminService;
import com.app.service.HospitalService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private HospitalService hospitalService;

	/**
	 * Save admin data
	 * 
	 * @param admin
	 * @return
	 */
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveAdmin(@RequestBody Admin admin) {
		String massage;
		if (admin != null) {
			Hospital hospital = hospitalService.getHospitalById(admin.getHospital().getId());
			admin.setHospital(hospital);
			int id = adminService.saveAdmin(admin);
			if (id > 0) {
				massage = "Admin Registered Successfuly with an Id :: " + id;
				return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
			} else {
				massage = "Sorry !!! Admin Registered Failed";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			massage = "Sorry !!! Admin Registered Failed";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * Update admin data
	 * 
	 * @param admin
	 * @return
	 */
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) {
		String massage;
		if (admin != null) {
			adminService.updateAdmin(admin);
			massage = "Admin updated";
			return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
		} else {
			massage = "Admin data not updated";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * Get admin by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getAdmin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAdminById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			Admin admin = adminService.getAdminById(id);
			if (admin != null) {
				return new ResponseEntity<Admin>(admin, HttpStatus.FOUND);
			} else {
				massage = "Admin not found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			massage = "Please select id";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Get all admins
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllAdmin() {
		List<Admin> admins = adminService.getAllAdmin();
		if (admins != null && admins.size() > 0) {
			return new ResponseEntity<List<Admin>>(admins, HttpStatus.FOUND);
		} else {
			String massage = "Admin not found";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Delete admin by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteAdminById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			adminService.deleteAdminById(id);
			massage = "Admin deleted";
		} else {
			massage = "Admin not deleted";
		}
		return new ResponseEntity<String>(massage, HttpStatus.OK);
	}

	/**
	 * Search admins using options
	 * 
	 * @param option
	 * @return
	 */
	@GetMapping(value = "/search/{option}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchAdmins(@PathVariable("option") String option) {
		String massage;
		if (option != null) {
			List<Admin> admins = adminService.searchAdmins(option);
			if (admins != null && admins.size() > 0) {
				return new ResponseEntity<List<Admin>>(admins, HttpStatus.FOUND);
			} else {
				massage = "Record not found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			massage = "Enter some key to find record";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Change admin status
	 * 
	 * @author VINAYAK
	 * @param id
	 * @return
	 */
	@GetMapping("/status/{id}")
	public ResponseEntity<String> changeStatus(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			Admin admin = adminService.getAdminById(id);
			boolean status = admin.getStatus();
			if (status) {
				admin.setStatus(false);
				adminService.changeStatus(admin);
				massage = "Admin status change to De-Active";
			} else {
				admin.setStatus(false);
				adminService.changeStatus(admin);
				massage = "Admin status change to De-Active";
			}
			return new ResponseEntity<String>(massage, HttpStatus.OK);
		} else {
			massage = "Please select admin to change status";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}
}
