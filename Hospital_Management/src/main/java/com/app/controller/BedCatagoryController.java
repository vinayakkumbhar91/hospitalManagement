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

import com.app.domain.BedCatagory;
import com.app.service.BedCatagoryService;

@RestController
@RequestMapping("/bedCatagory")
public class BedCatagoryController {

	@Autowired
	private BedCatagoryService bedCatagoryService;

	/**
	 * Save bed catagory
	 * 
	 * @param bedCatagoty
	 * @return
	 */
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBedCatagory(@RequestBody BedCatagory bedCatagoty) {
		String massage;
		if (bedCatagoty != null) {
			int id = bedCatagoryService.addBedCatagory(bedCatagoty);
			if (id > 0) {
				massage = "Bed acatagory saved witha an id " + id;
				return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
			} else {
				massage = "Bed acatagory not saved ";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			massage = "Please enter valid data ";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * update bed catagory
	 * 
	 * @param bedCatagory
	 * @return
	 */
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateBedCatagory(@RequestBody BedCatagory bedCatagory) {
		String massage;
		if (bedCatagory != null) {
			bedCatagoryService.updateBedCatagory(bedCatagory);
			massage = "Bed acatagory updated ";
			return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
		} else {
			massage = "Please enter valid data ";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * bed catagory deleted
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteBedCatagoryById(int id) {
		String massage;
		if (id > 0) {
			bedCatagoryService.deleteBedCatagoryById(id);
			massage = "Bed catagory deleted";
			return new ResponseEntity<String>(massage, HttpStatus.OK);
		} else {
			massage = "Bed catagory deletion failed";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * get bed category by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getbedcat/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBedCatagoryById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			BedCatagory bedCatagory = bedCatagoryService.getBedCatagoryById(id);
			if (bedCatagory != null) {
				return new ResponseEntity<BedCatagory>(bedCatagory, HttpStatus.FOUND);
			} else {
				massage = "Bed catagory not found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			massage = "Please enter valid id";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Get all bed categories
	 * 
	 * @return
	 */
	@GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllBedCatagory() {
		List<BedCatagory> bedCatagorys = bedCatagoryService.getAllBedCatagory();
		if (bedCatagorys != null && bedCatagorys.size() > 0) {
			return new ResponseEntity<List<BedCatagory>>(bedCatagorys, HttpStatus.FOUND);
		} else {
			String massage = "Bed catagorys not found";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Search bed category
	 * 
	 * @param option
	 * @return
	 */
	@GetMapping(value = "/search/{option}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchBedCatagory(@PathVariable("option") String option) {
		String massage;
		if (option != null && !option.equals("")) {
			List<BedCatagory> bedCatagorys = bedCatagoryService.getAllBedCatagory();
			if (bedCatagorys != null && bedCatagorys.size() > 0) {
				return new ResponseEntity<List<BedCatagory>>(bedCatagorys, HttpStatus.FOUND);
			} else {
				massage = "Bed catagorys not found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			massage = "Please enter search option";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}
}
