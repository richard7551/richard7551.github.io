package com.examen.RicardoGarcia.Repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examen.RicardoGarcia.ModelsPOJO.EmployeeModel;

@Repository
public interface IEmployeeRepository extends CrudRepository<EmployeeModel, Long> {

}
