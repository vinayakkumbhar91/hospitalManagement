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

import com.app.domain.MedicineCatagory;
import com.app.service.MedicineCatagoryService;

@RestController
@RequestMapping("/medicinecatagory")
public class MedicineCatagoryController {

	@Autowired
	private MedicineCatagoryService medicineCatagoryService;

	/**
	 * Save medicine catagory
	 * 
	 * @param medicineCatagory
	 * @return
	 */
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveMedicineCatagory(@RequestBody MedicineCatagory medicineCatagory) {
		String massage;
		if (medicineCatagory != null) {
			int id = medicineCatagoryService.addMedicineCatagory(medicineCatagory);
			if (id > 0) {
				massage = "Medicine Catagory saved with an id " + id;
				return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
			} else {
				massage = "Medicine Catagory is not saved";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			massage = "Please fill data first";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * update the medicine catagory
	 * 
	 * @param medicineCatagory
	 * @return
	 */
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateMedicineCatagory(@RequestBody MedicineCatagory medicineCatagory) {
		String massage;
		if (medicineCatagory != null) {
			medicineCatagoryService.updateMedicineCatagory(medicineCatagory);
			massage = "Medicine Catagory updated ";
			return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
		} else {
			massage = "Medicine Catagory not updated";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Delete mediacine catagory by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/delete/{catId}")
	public ResponseEntity<String> deleteMedicineCatagoryById(@PathVariable("catId") int id) {
		String massage;
		if (id > 0) {
			medicineCatagoryService.deleteMedicineCatagoryById(id);
			massage = "Medicine Catagory deleted successfuly";
			return new ResponseEntity<String>(massage, HttpStatus.OK);
		} else {
			massage = "Medicine Catagory deletion failed..please select record first";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * get medicin catagory by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getcat/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMedicineCatagoryById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			MedicineCatagory medicineCatagory = medicineCatagoryService.getMedicineCatagoryById(id);
			if (medicineCatagory != null) {
				return new ResponseEntity<MedicineCatagory>(medicineCatagory, HttpStatus.FOUND);
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
	 * get all medicine catagory
	 * 
	 * @return
	 */
	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllMedicineCatagory() {
		String massage;
		List<MedicineCatagory> medicineCatagories = medicineCatagoryService.getAllMedicineCatagory();
		if (!medicineCatagories.isEmpty() && medicineCatagories != null) {
			return new ResponseEntity<List<MedicineCatagory>>(medicineCatagories, HttpStatus.FOUND);
		} else {
			massage = "sorry ... medicine Catagories are not found";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Search medicine catagory
	 * 
	 * @param option
	 * @return
	 */
	@GetMapping(value = "/search/{option}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchMedicineCatagory(@PathVariable("option") String option) {
		String massage;
		if (option != null && !option.equals("")) {
			List<MedicineCatagory> catagories = medicineCatagoryService.searchMedicineCatagory(option);
			if (catagories != null && !catagories.isEmpty()) {
				return new ResponseEntity<List<MedicineCatagory>>(catagories, HttpStatus.FOUND);
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
