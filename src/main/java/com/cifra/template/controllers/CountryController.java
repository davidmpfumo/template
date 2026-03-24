package com.cifra.template.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cifra.template.models.Country;
import com.cifra.template.services.CountryService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping
	public String getCountries(Model model) {

		List<Country> countries = countryService.getCountries();

		for (Iterator<Country> iterator = countries.iterator(); iterator.hasNext();) {
			Country country = (Country) iterator.next();

			Hibernate.initialize(country);
			// Hibernate.initialize(country.getStates());
		}

		model.addAttribute("countries", countries);

		return "country";
	}

	@PostMapping("/addNew")
	public String addNew(Country country) {

		countryService.save(country);
		return "redirect:/countries";
	}

	@RequestMapping("/findById/{id}")
	@ResponseBody
	public Country findById(@PathVariable(name = "id") int id, Model model) {

		Optional<Country> country = countryService.findById(id);

		if (country.get() != null) {

			Hibernate.initialize(country);
			model.addAttribute("country", country);

			return country.get();

		}

		return null;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Country country) {
		countryService.save(country);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(@PathVariable(name = "id") int id) {
		countryService.delete(id);
		return "redirect:/countries";
	}

	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws IOException {
//		response.setContentType("application/octet-stream");
//		String headerKey = "Content-Disposition";
//		String headerValue = "attachment; filename=usuarios.xlsx";
//		response.setHeader(headerKey, headerValue);

		setReportParameters(response, "xls", "filename=all_coutries.xls");

		List<Country> countries = countryService.getCountries();
		// Lógica Apache POI para preencher Excel aqui

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Users");

		// Create header row
		Row headerRow = ((Sheet) sheet).createRow(0);
		((Row) headerRow).createCell(0).setCellValue("Code");
		headerRow.createCell(1).setCellValue("Description");
		headerRow.createCell(2).setCellValue("Capital");
		headerRow.createCell(3).setCellValue("Nationality");
		headerRow.createCell(3).setCellValue("Continent");

		// Populate data rows
		int rowNum = 1;
		for (Country country : countries) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(country.getCode());
			row.createCell(1).setCellValue(country.getDescription());
			row.createCell(2).setCellValue(country.getCapital());
			row.createCell(3).setCellValue(country.getNationality());
			row.createCell(3).setCellValue(country.getContinent());
		}

		// Write to response stream
		try (OutputStream outputStream = response.getOutputStream()) {
			workbook.write(outputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		workbook.close();
	}

	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse response) throws IOException {
		setReportParameters(response, "pdf", "filename=all_countries.pdf");
		// Lógica OpenPDF para preencher PDF aqui
	}

	private void setReportParameters(HttpServletResponse response, String contentType, String fileName) {
		response.setContentType("application/".concat(contentType));
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;".concat(fileName);
		response.setHeader(headerKey, headerValue);
	}

}
