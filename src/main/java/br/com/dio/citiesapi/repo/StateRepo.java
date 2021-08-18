package br.com.dio.citiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.citiesapi.model.State;

public interface StateRepo extends JpaRepository<State, Long> {

}
