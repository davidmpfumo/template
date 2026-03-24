package com.cifra.template.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cifra.template.models.Country;
import com.cifra.template.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	// List of countries
	public List<Country> getCountries() {

		List<Country> coutries = countryRepository.findAll();

		return coutries;
	}

	// save new Country
	public void save(Country country) {

		countryRepository.save(country);

	}

	// Get Country By Id
	public Optional<Country> findById(int id) {

		Optional<Country> country = countryRepository.findById(id);

		return country;
	}
	
	//Delete Contact
	public void delete(int id) {
		countryRepository.deleteById(id);
	}

}
