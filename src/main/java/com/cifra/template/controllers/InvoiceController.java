package com.cifra.template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceController {
	
	@GetMapping("/invoices")
	public String getCountries() {
		return "invoice";
	}


}
