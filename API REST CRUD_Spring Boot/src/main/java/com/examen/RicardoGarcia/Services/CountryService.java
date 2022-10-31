package com.examen.RicardoGarcia.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.RicardoGarcia.ModelsPOJO.CountryModel;
import com.examen.RicardoGarcia.Repositorys.ICountryRepository;

@Service
public class CountryService {
	
	@Autowired
	ICountryRepository countryRepository;
	
	//Find All
	public ArrayList<CountryModel> obtenerCountrys() {
		return (ArrayList<CountryModel>) countryRepository.findAll();
	}
	
	// Save
	public CountryModel guardarCountry(CountryModel country) {
		return countryRepository.save(country);
	}

	// Find By ID
	public Optional<CountryModel> obtenerCountryById(Long id) {
		return countryRepository.findById(id);
	}

	// Delete By ID
	public boolean eliminarCountry(Long id) {
		try {
			countryRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}

}
