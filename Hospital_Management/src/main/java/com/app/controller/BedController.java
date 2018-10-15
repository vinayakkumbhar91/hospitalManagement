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

import com.app.domain.Bed;
import com.app.service.BedService;

@RestController
@RequestMapping("/bed")
public class BedController {

	@Autowired
	private BedService bedService;

	/**
	 * Save bed category
	 * 
	 * @param bedCatagoty
	 * @return
	 */
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBed(@RequestBody Bed bed) {
		String massage;
		if (bed != null) {
			int id = bedService.addBed(bed);
			if (id > 0) {
				massage = "Bed saved witha an id " + id;
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
	 * update bed
	 * 
	 * @param Bed
	 * @return
	 */
	@PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateBed(@RequestBody Bed bed) {
		String massage;
		if (bed != null) {
			bedService.updateBed(bed);
			massage = "Bed updated ";
			return new ResponseEntity<String>(massage, HttpStatus.ACCEPTED);
		} else {
			massage = "Please enter valid data ";
			return new ResponseEntity<String>(massage, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	/**
	 * bed category deleted
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteBedById(int id) {
		String massage;
		if (id > 0) {
			bedService.deleteBedById(id);
			massage = "Bed deleted";
			return new ResponseEntity<String>(massage, HttpStatus.OK);
		} else {
			massage = "Bed deletion failed";
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
	public ResponseEntity<?> getBedById(@PathVariable("id") int id) {
		String massage;
		if (id > 0) {
			Bed bed = bedService.getBedById(id);
			if (bed != null) {
				return new ResponseEntity<Bed>(bed, HttpStatus.FOUND);
			} else {
				massage = "Bed not found";
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
	public ResponseEntity<?> getAllBed() {
		List<Bed> Beds = bedService.getAllBed();
		if (Beds != null && Beds.size() > 0) {
			return new ResponseEntity<List<Bed>>(Beds, HttpStatus.FOUND);
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
	public ResponseEntity<?> searchBed(@PathVariable("option") String option) {
		String massage;
		if (option != null && !option.equals("")) {
			List<Bed> beds = bedService.getAllBed();
			if (beds != null && beds.size() > 0) {
				return new ResponseEntity<List<Bed>>(beds, HttpStatus.FOUND);
			} else {
				massage = "Bed not found";
				return new ResponseEntity<String>(massage, HttpStatus.NOT_FOUND);
			}
		} else {
			massage = "Please enter search option";
			return new ResponseEntity<String>(massage, HttpStatus.BAD_REQUEST);
		}
	}
}