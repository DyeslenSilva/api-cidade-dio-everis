package br.com.dio.citiesapi.resource;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.citiesapi.model.State;
import br.com.dio.citiesapi.repo.StateRepo;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/staties")
@AllArgsConstructor
public class StateResouce {

	
	private StateRepo stateRepo;
	
	public List<State> staties(){
		return stateRepo.findAll();
	}
	
	
	
}
