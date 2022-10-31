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

import com.examen.RicardoGarcia.ModelsPOJO.EmployeeModel;
import com.examen.RicardoGarcia.Services.EmployeeService;

@RestController
@RequestMapping("/endpointEmployee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//Find All
	@GetMapping("/all")
	public ArrayList<EmployeeModel> obtenerEmployees() {
		return employeeService.obtenerEmployees();
	}
	
	//Save
	@PostMapping("/new")
	public EmployeeModel guardarEmployee(@RequestBody EmployeeModel employee) {
		return this.employeeService.guardarEmployee(employee);
	}
	
	//Find By ID
	@GetMapping( path = "/{id}")
	public Optional<EmployeeModel> obtenerEmployeeById(@PathVariable("id") Long id){
		return this.employeeService.obtenerEmployeeById(id);
	}
	
	//Delete By ID
	@DeleteMapping( path = "/{id}")
	public String eliminarEmployeeById(@PathVariable("id") Long id){
		boolean ok = this.employeeService.eliminarEmployee(id);
		if (ok) {
			return "Se eliminó el Employee con ID: " +id;
		} else {
			return "NO SE PUDO ELIMINAR el Employee con ID: " +id;
		}
	}
	
	//Update By ID
	@PutMapping( path = "/{id}")
	public EmployeeModel actualizarEmployee(@RequestBody EmployeeModel employeeToUpdate) {
		EmployeeModel employeeUpdated = employeeToUpdate;
		return this.employeeService.guardarEmployee(employeeUpdated);
	}
	
}
