package com.examen.RicardoGarcia.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examen.RicardoGarcia.ModelsPOJO.EmployeeModel;
import com.examen.RicardoGarcia.Repositorys.IEmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	//Find All
	public ArrayList<EmployeeModel> obtenerEmployees(){
		return (ArrayList<EmployeeModel>) employeeRepository.findAll();
	}
	
	//Save
	public EmployeeModel guardarEmployee(EmployeeModel employee) {
		return employeeRepository.save(employee);
	}
	
	//Find By ID
	public Optional<EmployeeModel> obtenerEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}
	
	//Delete By ID
	public boolean eliminarEmployee(Long id) {
		try {
			employeeRepository.deleteById(id);
			return true;
		} catch (Exception err) {
			return false;
		}
	}

}
