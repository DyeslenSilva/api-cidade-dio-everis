package br.com.dio.citiesapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.citiesapi.model.City;

public interface CityRepo extends JpaRepository<City, Long> {

	Double distanceByPoints(Long city1, Long city2);

	Double distanceByCube(double x, double y, double x2, double y2);


}
