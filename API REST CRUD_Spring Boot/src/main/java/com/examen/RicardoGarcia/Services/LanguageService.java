package com.examen.RicardoGarcia.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.RicardoGarcia.ModelsPOJO.LanguageModel;
import com.examen.RicardoGarcia.Repositorys.ILanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	ILanguageRepository languageRepository;
	
	// Find All
	public ArrayList<LanguageModel> obtenerLanguages() {
		return (ArrayList<LanguageModel>) languageRepository.findAll();
	}

	// Save
	public LanguageModel guardarLanguage(LanguageModel language) {
		return languageRepository.save(language);
	}

	// Find By ID
	public Optional<LanguageModel> obtenerLanguageById(Long id) {
		return languageRepository.findById(id);
	}

	// Delete By ID
	public boolean eliminarLanguage(Long id) {
		try {
			languageRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}

}
