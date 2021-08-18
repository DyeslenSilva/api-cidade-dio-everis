package br.com.dio.citiesapi.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.citiesapi.model.City;
import br.com.dio.citiesapi.repo.CityRepo;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityResouce {

	private CityRepo cityRepo;
	
	@GetMapping
	public Page<City> getAllCities(final Pageable pageable){
		return  cityRepo.findAll(pageable);
	}
	
	
}
