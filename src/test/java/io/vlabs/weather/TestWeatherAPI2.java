package io.vlabs.weather;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestWeatherAPI2 {
	
//	api.openweathermap.org/data/2.5/weather?q={city name}&appid={your api key}
//	api.openweathermap.org/data/2.5/weather?q=chennai&appid=4cbd940cd6f8032fa1c49d3cef8e9162
//	api.openweathermap.org/data/2.5/weather?q=chennai&units=metric&appid=4cbd940cd6f8032fa1c49d3cef8e9162
	
	@Test
	public void checkConnection() {
		RestAssured.baseURI = "https://api.openweathermap.org";

		
		RequestSpecification httpRequest = RestAssured.given();
				
		Response response = httpRequest.request(Method.GET, "/data/2.5/weather?q=chennai&units=metric&appid=4cbd940cd6f8032fa1c49d3cef8e9162");

		
		
		String respBody = response.getBody().asString();
		System.out.println(respBody);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
		
	}
}
