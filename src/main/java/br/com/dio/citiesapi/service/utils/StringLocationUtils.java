package br.com.dio.citiesapi.service.utils;

public class StringLocationUtils {
	
	public static Double[] transform(String geolocation) {
		String result = geolocation.replace(")", "");
		String[] strings = result.trim().split(",");
		return new Double[] 
			{Double.valueOf(strings[0]),Double.valueOf(strings[1])};
	}
}
