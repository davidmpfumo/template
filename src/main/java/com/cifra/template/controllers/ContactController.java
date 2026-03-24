package com.cifra.template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

	@GetMapping("/contacts")
	public String getCountries() {
		return "contact";
	}
}
