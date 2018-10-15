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

import com.app.domain.Patient;
import com.app.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;

	/**
	 * Save Patient data
	 * 
	 * @param Patient
	 * @return
	 */
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> savePatient(@RequestBody Patient patient) {
		String massage;
		if (patient != null) {
			int id = patientService.savePatient(patient);
			if (id > 0) {
				massage = "Patient Registered ";
				return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
			} else {
				massage = "Sorry !!! Patient Registered Failed";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
			}

		} else {
			massage = "Sorry !!! Patient Registered Failed";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * Update Patient data
	 * 
	 * @param Patient
	 * @return
	 */
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updatePatient(@RequestBody Patient patient) {
		String massage;
		if (patient != null) {
			patientService.updatePatient(patient);
			massage = "Patient updated";
			return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
		} else {
			massage = "Patient data not updated";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * Get Patient by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getPatient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPatientById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			Patient patient = patientService.getPatientById(id);
			if (patient != null) {
				return new ResponseEntity<Patient>(patient, HttpStatus.FOUND);
			} else {
				massage = "Patient not found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			massage = "Please select id";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Get all Patients
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllPatient() {
		List<Patient> patients = patientService.getAllPatient();
		if (patients != null && patients.size() > 0) {
			return new ResponseEntity<List<Patient>>(patients, HttpStatus.FOUND);
		} else {
			String massage = "Patient not found";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Delete Patient by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deletePatientById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			patientService.deletePatientById(id);
			massage = "Patient deleted";
		} else {
			massage = "Patient not deleted";
		}
		return new ResponseEntity<String>(massage, HttpStatus.OK);
	}

	/**
	 * Search Patients using options
	 * 
	 * @param option
	 * @return
	 */
	@GetMapping(value = "/search/{option}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchPatients(@PathVariable("option") String option) {
		String massage;
		if (option != null) {
			List<Patient> patients = patientService.searchPatients(option);
			if (patients != null && patients.size() > 0) {
				return new ResponseEntity<List<Patient>>(patients, HttpStatus.FOUND);
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
	 * Change Patient status
	 * 
	 * @author VINAYAK
	 * @param id
	 * @return
	 */
	@GetMapping("/status/{id}")
	public ResponseEntity<String> changeStatus(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			Patient patient = patientService.getPatientById(id);
			boolean status = patient.isStatus();
			if (status) {
				patient.setStatus(false);
				patientService.changeStatus(patient);
				massage = "Patient status change to De-Active";
			} else {
				patient.setStatus(false);
				patientService.changeStatus(patient);
				massage = "Patient status change to De-Active";
			}
			return new ResponseEntity<String>(massage, HttpStatus.OK);
		} else {
			massage = "Please select Patient to change status";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * assign patient to doctor
	 * 
	 * @param docid
	 * @param patid
	 * @return
	 */
	@GetMapping("/assigndoc/{docid}/{patid}")
	public ResponseEntity<String> assignDoctor(@PathVariable("docid") int docid, @PathVariable("patid") int patid) {
		String massage;
		if (docid > 0 && patid > 0) {
			patientService.assignDoctor(docid, patid);
			massage = "Patient assigned to the doctor";
			return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
		} else {
			massage = "Patient not assigned to the doctor";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * Unassign doctor rom patient
	 * 
	 * @param docid
	 * @param patid
	 * @return
	 */
	@GetMapping("/unassigndoc/{docid}/{patid}")
	public ResponseEntity<String> unassignDoctor(@PathVariable("docid") int docid, @PathVariable("patid") int patid) {
		String massage;
		if (docid > 0 && patid > 0) {
			patientService.unassingDoctor(docid, patid);
			massage = " unassigned doctor";
			return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
		} else {
			massage = "not unassigned doctor";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
