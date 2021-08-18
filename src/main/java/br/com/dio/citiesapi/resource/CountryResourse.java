package br.com.dio.citiesapi.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.citiesapi.model.Country;
import br.com.dio.citiesapi.repo.CountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryResourse {

	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping
	public Page<Country> coutries(Pageable pageable){
		return countryRepository.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		Optional<Country> optional = countryRepository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok().body(optional.get());

		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
}
