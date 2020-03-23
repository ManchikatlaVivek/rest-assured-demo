package io.vlabs.weather;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class Test_Post_Request {

	public void testPort() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		String name = "abcdef1234";
		requestParams.put("FirstName", name);
		requestParams.put("LastName", name);
		requestParams.put("UserName", name);
		requestParams.put("Password", name);
		requestParams.put("Email", name+"@gmail.com");

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST, "/register");

		String respBody = response.getBody().asString();
		System.out.println(respBody);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
		String responseCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(responseCode, "OPERATION_SUCCESS");
	}

}
