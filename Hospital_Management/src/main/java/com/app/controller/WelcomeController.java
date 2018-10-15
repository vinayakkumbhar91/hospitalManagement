package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class WelcomeController {
	/**
	 * Welcome massage controller .......
	 * 
	 * @return
	 */
	@GetMapping(value = "/welcome")
	public ResponseEntity<String> show() {
		String msg = "Welcome To The Hospital Management";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
