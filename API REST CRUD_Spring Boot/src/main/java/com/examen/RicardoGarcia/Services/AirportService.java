package com.examen.RicardoGarcia.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.RicardoGarcia.ModelsPOJO.AirportModel;
import com.examen.RicardoGarcia.Repositorys.IAirportRepository;

@Service
public class AirportService {

	@Autowired
	IAirportRepository airportRepository;

	// Find All
	public ArrayList<AirportModel> obtenerAirports() {
		return (ArrayList<AirportModel>) airportRepository.findAll();
	}

	// Save
	public AirportModel guardarAirport(AirportModel airport) {
		return airportRepository.save(airport);
	}

	// Find By ID
	public Optional<AirportModel> obtenerAirportById(Long id) {
		return airportRepository.findById(id);
	}

	// Delete By ID
	public boolean eliminarAirport(Long id) {
		try {
			airportRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}

}
