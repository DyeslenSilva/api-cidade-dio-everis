package br.com.dio.citiesapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.citiesapi.model.Country;
import br.com.dio.citiesapi.repo.CountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryResourse {

	@Autowired
	private CountryRepository countryRepository;
	
	public java.util.List<Country> coutries(){
		return countryRepository.findAll();
	}
}
