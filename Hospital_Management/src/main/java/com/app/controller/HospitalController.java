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

import com.app.domain.Hospital;
import com.app.service.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	/**
	 * saving a hospital to the database
	 * @param hospital
	 * @return
	 */
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveHospital(@RequestBody Hospital hospital) {
		String massage;
		if (hospital != null) {
			int id = hospitalService.saveHospital(hospital);
			if (id > 0) {
				massage = "Great !!! Hospital save with an id " + id;
				return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
			} else {
				massage = "Ohhh !!! Hospital Registration failed";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			massage = "Ohhh !!! Hospital Registration failed";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}

	}

	/**
	 * updating Hospital
	 * 
	 * @param hospital
	 * @return
	 */
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital) {
		String massage;
		if (hospital != null) {
			int id = hospitalService.updateHospital(hospital);
			if (id == hospital.getId()) {
				massage = "Great !!! Hospital is updated";
				return new ResponseEntity<String>(massage, HttpStatus.CREATED);
			} else {
				massage = "Ohhh !!! Hospital is not updated";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			massage = "Ohhh !!! Hospital is not updated";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * Get hospital by id
	 */
	@GetMapping(value = "/getHospital/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getHospitalById(@PathVariable("id") int id) {
		if (id > 0) {
			Hospital hospital = hospitalService.getHospitalById(id);
			if (hospital != null) {
				return new ResponseEntity<Hospital>(hospital, HttpStatus.FOUND);
			} else {
				String massage = "Hospital Not Found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			String massage = "Hospital Not Found";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Get all Hospital
	 * 
	 * @author VINAYAK
	 */
	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllHospital() {
		List<Hospital> hospitals = hospitalService.getAllHospital();
		if (hospitals != null && hospitals.size() > 0) {
			return new ResponseEntity<List<Hospital>>(hospitals, HttpStatus.FOUND);
		} else {
			String massage = "sorry No hospital found";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Delete hospital by id
	 * 
	 * @author VINAYAK
	 */
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteHospitalById(@PathVariable("id") int id) {
		hospitalService.deleteHospitalById(id);
		String massage = "Hospital deleted successfuly";
		return new ResponseEntity<String>(massage, HttpStatus.OK);
	}

	/**
	 * Search hospital based on options
	 * 
	 * @author VINAYAK
	 */
	@GetMapping(value = "/search/{option}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchHospital(@PathVariable("option") String option) {
		if (option != null && !option.equals("")) {
			List<Hospital> hospitals = hospitalService.searchHospitals(option);
			return new ResponseEntity<List<Hospital>>(hospitals, HttpStatus.FOUND);
		} else {
			String massage = "Please enter some character to search";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Change the Hospital status
	 * 
	 * @author VINAYAK
	 */
	@GetMapping("/changestatus/{id}")
	public ResponseEntity<String> changeStatus(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			Hospital hospital = hospitalService.getHospitalById(id);
			boolean status = hospital.getStatus();
			if (status == true) {
				hospital.setStatus(false);
				hospitalService.changeStatus(hospital);
				massage = "Status updated to De-Active!!!!";
				return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
			}
			else {
				hospital.setStatus(true);
				hospitalService.changeStatus(hospital);
				massage = "Status updated to Active!!!!";
				return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
			}
		}
		else {
			massage = "Please select hospital";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
