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

import com.examen.RicardoGarcia.ModelsPOJO.AirportModel;
import com.examen.RicardoGarcia.Services.AirportService;

@RestController
@RequestMapping("/endpointAirport")
public class AirportController {

	@Autowired
	AirportService airportService;

	// Find All
	@GetMapping("/all")
	public ArrayList<AirportModel> obtenerAirports() {
		return airportService.obtenerAirports();
	}

	// Save
	@PostMapping("/new")
	public AirportModel guardarAirport(@RequestBody AirportModel airport) {
		return this.airportService.guardarAirport(airport);
	}

	// Find By ID
	@GetMapping(path = "/{id}")
	public Optional<AirportModel> obtenerAirportById(@PathVariable("id") Long id) {
		return this.airportService.obtenerAirportById(id);
	}

	// Delete By ID
	@DeleteMapping(path = "/{id}")
	public String eliminarAirportById(@PathVariable("id") Long id) {
		boolean ok = this.airportService.eliminarAirport(id);
		if (ok) {
			return "Se eliminó el Contry con ID: " + id;
		} else {
			return "NO SE PUDO ELIMINAR el Country con ID: " + id;
		}
	}

	// Update By ID
	@PutMapping(path = "/{id}")
	public AirportModel actualizarAirport(@RequestBody AirportModel airportToUpdate) {
		AirportModel airportUpdated = airportToUpdate;
		return this.airportService.guardarAirport(airportUpdated);
	}

}
