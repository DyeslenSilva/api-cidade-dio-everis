package br.com.dio.citiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.citiesapi.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
