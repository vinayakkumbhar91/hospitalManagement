package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	@GetMapping(value = "/show")
	public String show() {
		return "welcome";
	}

	@GetMapping(value = "/superadmin")
	public String superAdmin() {
		return "superadmin";
	}

}
