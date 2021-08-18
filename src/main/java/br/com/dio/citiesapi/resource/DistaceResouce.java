package br.com.dio.citiesapi.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.citiesapi.service.DistanceService;
import br.com.dio.citiesapi.service.enumeration.EarthRadius;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/distances")
public class DistaceResouce {
	
	@Autowired
	private final DistanceService distanceService;
	
	Logger logger = LoggerFactory.getLogger(DistaceResouce.class);
	
	
	@GetMapping("/byPoints")
	public Double byPoints(@RequestParam(name = "from") final Long city1,
							@RequestParam(name = "to")final Long city2) {
		logger.info("by-points");
		return distanceService.distanceByPointsInMiles(city1, city2);
	}
	
	
	@GetMapping("/byCube")
	public Double byCube(@RequestParam(name = "from") final Long city1,
							@RequestParam(name = "to")final Long city2) {
		logger.info("by-cube");
		return distanceService.distanceByCubeInMeters(city1, city2);
	}
	
	@GetMapping("/byMath")
	public Double byMath(@RequestParam(name = "from")final Long city1,
						@RequestParam(name = "to") final Long city2,
						@RequestParam final EarthRadius unit) {
		
		logger.info("by-math");
		return distanceService.distanceUsingMath(city1, city2, unit);
	}
	
	
	
	
	}
