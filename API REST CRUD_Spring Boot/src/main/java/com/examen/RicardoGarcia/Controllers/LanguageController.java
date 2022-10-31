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

import com.examen.RicardoGarcia.ModelsPOJO.LanguageModel;
import com.examen.RicardoGarcia.Services.LanguageService;

@RestController
@RequestMapping("/endpointLanguage")
public class LanguageController {
	
	@Autowired
	LanguageService languageService;
	
	// Find All
	@GetMapping("/all")
	public ArrayList<LanguageModel> obtenerLanguages() {
		return languageService.obtenerLanguages();
	}

	// Save
	@PostMapping("/new")
	public LanguageModel guardarLanguage(@RequestBody LanguageModel language) {
		return this.languageService.guardarLanguage(language);
	}

	// Find By ID
	@GetMapping(path = "/{id}")
	public Optional<LanguageModel> obtenerLanguageById(@PathVariable("id") Long id) {
		return this.languageService.obtenerLanguageById(id);
	}

	// Delete By ID
	@DeleteMapping(path = "/{id}")
	public String eliminarLanguageById(@PathVariable("id") Long id) {
		boolean ok = this.languageService.eliminarLanguage(id);
		if (ok) {
			return "Se eliminó el Contry con ID: " + id;
		} else {
			return "NO SE PUDO ELIMINAR el Country con ID: " + id;
		}
	}

	// Update By ID
	@PutMapping(path = "/{id}")
	public LanguageModel actualizarLanguage(@RequestBody LanguageModel languageToUpdate) {
		LanguageModel languageUpdated = languageToUpdate;
		return this.languageService.guardarLanguage(languageUpdated);
	}

}
