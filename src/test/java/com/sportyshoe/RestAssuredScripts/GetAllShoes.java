package com.sportyshoe.RestAssuredScripts;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import io.restassured.RestAssured;

public class GetAllShoes {
	@Test(priority='1')
	public void get_all_shoes()
	{
		Response res=RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/get-shoes")
		.when()
		.get()
		.then()
		.log()
		.all()
		.body("message",Matchers.equalTo("24 Shoes Fetched Successfully."))
		.extract()
		.response();
		int expectedstatuscode=200;
		int Actualstatuscode=res.getStatusCode();
		Assert.assertEquals(expectedstatuscode, Actualstatuscode);
	}
	@Test(priority='2')
	public void get_all_users() {
		Response res=RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/get-users")
		.when()
		.get()
		.then()
		.log()
		.all()
		.body("message",Matchers.equalTo("3 Users Fetched Successfully."))
		.extract()
		.response();
		int expectedstatuscode=200;
		int Actualstatuscode=res.getStatusCode();
		Assert.assertEquals(expectedstatuscode, Actualstatuscode);
		
	}
}
