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

import com.app.domain.Doctor;
import com.app.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	/**
	 * Save Doctor data
	 * 
	 * @param Doctor
	 * @return
	 */
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveDoctor(@RequestBody Doctor doctor) {
		String massage;
		if (doctor != null) {
			int id = doctorService.saveDoctor(doctor);
			if (id > 0) {
				massage = "Doctor Registered ";
				return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
			} else {
				massage = "Sorry !!! Doctor Registered Failed";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
			}

		} else {
			massage = "Sorry !!! Doctor Registered Failed";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * Update Doctor data
	 * 
	 * @param Doctor
	 * @return
	 */
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateDoctor(@RequestBody Doctor doctor) {
		String massage;
		if (doctor != null) {
			doctorService.updateDoctor(doctor);
			massage = "Doctor updated";
			return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
		} else {
			massage = "Doctor data not updated";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * Get Doctor by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getDoctor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDoctorById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			Doctor doctor = doctorService.getDoctorById(id);
			if (doctor != null) {
				return new ResponseEntity<Doctor>(doctor, HttpStatus.FOUND);
			} else {
				massage = "Doctor not found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			massage = "Please select id";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Get all Doctors
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllDoctor() {
		List<Doctor> doctors = doctorService.getAllDoctor();
		if (doctors != null && doctors.size() > 0) {
			return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.FOUND);
		} else {
			String massage = "Doctor not found";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Delete Doctor by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			doctorService.deleteDoctorById(id);
			massage = "Doctor deleted";
		} else {
			massage = "Doctor not deleted";
		}
		return new ResponseEntity<String>(massage, HttpStatus.OK);
	}

	/**
	 * Search Doctors using options
	 * 
	 * @param option
	 * @return
	 */
	@GetMapping(value = "/search/{option}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchDoctors(@PathVariable("option") String option) {
		String massage;
		if (option != null) {
			List<Doctor> doctors = doctorService.searchDoctors(option);
			if (doctors != null && doctors.size() > 0) {
				return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.FOUND);
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
	 * Change Doctor status
	 * 
	 * @author VINAYAK
	 * @param id
	 * @return
	 */
	@GetMapping("/status/{id}")
	public ResponseEntity<String> changeStatus(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			Doctor doctor = doctorService.getDoctorById(id);
			boolean status = doctor.isStatus();
			if (status) {
				doctor.setStatus(false);
				doctorService.changeStatus(doctor);
				massage = "Doctor status change to De-Active";
			} else {
				doctor.setStatus(false);
				doctorService.changeStatus(doctor);
				massage = "Doctor status change to De-Active";
			}
			return new ResponseEntity<String>(massage, HttpStatus.OK);
		} else {
			massage = "Please select Doctor to change status";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}
}
