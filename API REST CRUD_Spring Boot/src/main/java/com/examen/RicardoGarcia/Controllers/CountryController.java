package com.examen.RicardoGarcia.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.RicardoGarcia.ModelsPOJO.CountryModel;
import com.examen.RicardoGarcia.Services.CountryService;

@RestController
@RequestMapping("/endpointCountry")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	// Find All
	@GetMapping("/all")
	public ArrayList<CountryModel> obtenerCountrys() {
		return countryService.obtenerCountrys();
	}

	// Save
	@PostMapping("/new")
	public CountryModel guardarCountry(@RequestBody CountryModel country) {
		return this.countryService.guardarCountry(country);
	}

	// Find By ID
	@GetMapping(path = "/{id}")
	public Optional<CountryModel> obtenerCountryById(@PathVariable("id") Long id) {
		return this.countryService.obtenerCountryById(id);
	}

	// Delete By ID
	@DeleteMapping(path = "/{id}")
	public String eliminarCountryById(@PathVariable("id") Long id) {
		boolean ok = this.countryService.eliminarCountry(id);
		if (ok) {
			return "Se eliminó el Contry con ID: " + id;
		} else {
			return "NO SE PUDO ELIMINAR el Country con ID: " + id;
		}
	}

	// Update By ID
	@PutMapping(path = "/{id}")
	public CountryModel actualizarCountry(@RequestBody CountryModel countryToUpdate) {
		CountryModel countryUpdated = countryToUpdate;
		return this.countryService.guardarCountry(countryUpdated);
	}

}
