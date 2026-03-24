package com.cifra.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cifra.template.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
