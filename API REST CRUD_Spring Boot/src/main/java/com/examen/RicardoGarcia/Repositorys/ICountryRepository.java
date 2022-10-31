package com.examen.RicardoGarcia.Repositorys;

import org.springframework.data.repository.CrudRepository;

import com.examen.RicardoGarcia.ModelsPOJO.CountryModel;

public interface ICountryRepository extends CrudRepository<CountryModel, Long> {

}
