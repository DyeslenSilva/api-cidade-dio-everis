package br.com.dio.citiesapi.service;

import java.util.Arrays;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import static java.lang.Math.toRadians;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

import br.com.dio.citiesapi.model.City;
import br.com.dio.citiesapi.repo.CityRepo;
import br.com.dio.citiesapi.service.enumeration.EarthRadius;
import br.com.dio.citiesapi.service.utils.StringLocationUtils;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DistanceService {

	private final CityRepo cityRepo;

	Logger logger = org.slf4j.LoggerFactory.getLogger(DistanceService.class);
	/**
	 * @param city1
	 * @param city2
	 * @param unit
	 * @return
	 */
	
	public Double distanceUsingMath(final long city1, final long city2, EarthRadius unit) {
		logger.info("distanceUsingMath({}, {}, {})" ,city1,city2, unit);
		final List<City> cities = cityRepo.findAllById(Arrays.asList(city1, city2));
		
		final Double[] location1 = StringLocationUtils.transform(cities.get(0).getGeoLocation());
		final Double[] location2 = StringLocationUtils.transform(cities.get(1).getGeoLocation());		
	
		return doCalculation(location1[0], location1[1],location2[0], location2[1], unit);
	}
	
	
	public Double distanceByCubeInMeters(Long city1, Long city2) {
	    logger.info("distanceByCubeInMeters({}, {})", city1, city2);
	    final List<City> cities = cityRepo.findAllById(Arrays.asList(city1,city2));
	    
	    Point p1 =cities.get(0).getPoint();
	    Point p2 = cities.get(1).getPoint();
	    
	    return cityRepo.distanceByCube(p1.getX(),p1.getY(), p2.getX(), p2.getY());
	    		
	}
	
	
	
	public Double distanceUsingPoints(final Long city1, final Long city2, final EarthRadius earthRadius) {
		logger.info("distanceUsingPoints({}, {}, {})",city1,city2, earthRadius);
		final List<City> cities = cityRepo.findAllById(Arrays.asList(city1,city2));
		
		Point p1 = cities.get(0).getPoint();
		Point p2 = cities.get(1).getPoint();
		
		return doCalculation(p1.getX(), p1.getY(), p2.getX(), p2.getY(), earthRadius);
	}
	
	public Double distanceByPointsInMiles(final Long city1, final Long city2) {
	    logger.info("nativePostgresInMiles({}, {})", city1, city2);
	    return cityRepo.distanceByPoints(city1,city2);
		
		
	}
	
	
	//@SuppressWarnings("unused")
		private double doCalculation(final double lat1, final double lon1, final double lat2,
										final double lon2, final EarthRadius earthRadius) {
			double lat = toRadians(lat2-lat1);
			double lon = toRadians(lon2-lon1);
			double a = sin(lat/2)*sin(lat/2)+
					cos(toRadians(lat1))*cos(toRadians(lat2))*
					sin(lon/2)*sin(lon/2);
			double c = 2* atan2(sqrt(a),sqrt(1-a));
			
			return earthRadius.getValue()*c;
			
		}
}
