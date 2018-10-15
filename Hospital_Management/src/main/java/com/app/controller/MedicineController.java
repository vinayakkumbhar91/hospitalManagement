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

import com.app.domain.Medicine;
import com.app.service.MedicineService;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	/**
	 * Save medicine
	 * 
	 * @param Medicine
	 * @return
	 */
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveMedicine(@RequestBody Medicine medicine) {
		String massage;
		if (medicine != null) {
			int id = medicineService.addMedicine(medicine);
			if (id > 0) {
				massage = "Medicine  saved with an id " + id;
				return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
			} else {
				massage = "Medicine  is not saved";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			massage = "Please fill data first";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * update the medicine
	 * 
	 * @param Medicine
	 * @return
	 */
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateMedicine(@RequestBody Medicine medicine) {
		String massage;
		if (medicine != null) {
			medicineService.updateMedicine(medicine);
			massage = "Medicine  updated ";
			return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
		} else {
			massage = "Medicine  not updated";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Delete medicine by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/delete/{catId}")
	public ResponseEntity<String> deleteMedicineById(@PathVariable("catId") int id) {
		String massage;
		if (id > 0) {
			medicineService.deleteMedicineById(id);
			massage = "Medicine  deleted successfuly";
			return new ResponseEntity<String>(massage, HttpStatus.OK);
		} else {
			massage = "Medicine  deletion failed..please select record first";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * get medicine by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getcat/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMedicineById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			Medicine medicine = medicineService.getMedicineById(id);
			if (medicine != null) {
				return new ResponseEntity<Medicine>(medicine, HttpStatus.FOUND);
			} else {
				massage = "Record  not found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			massage = "Please select record first";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * get all medicine
	 * 
	 * @return
	 */
	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllMedicine() {
		String massage;
		List<Medicine> medicine = medicineService.getAllMedicine();
		if (!medicine.isEmpty() && medicine != null) {
			return new ResponseEntity<List<Medicine>>(medicine, HttpStatus.FOUND);
		} else {
			massage = "sorry ... medicines are not found";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Search medicine
	 * 
	 * @param option
	 * @return
	 */
	@GetMapping(value = "/search/{option}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchMedicine(@PathVariable("option") String option) {
		String massage;
		if (option != null && !option.equals("")) {
			List<Medicine> medicines = medicineService.searchMedicine(option);
			if (medicines != null && !medicines.isEmpty()) {
				return new ResponseEntity<List<Medicine>>(medicines, HttpStatus.FOUND);
			} else {
				massage = "Record not found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			massage = "Please enter something to search";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}
}
