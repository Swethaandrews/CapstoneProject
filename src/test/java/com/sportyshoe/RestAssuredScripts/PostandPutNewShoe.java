package com.sportyshoe.RestAssuredScripts;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
public class PostandPutNewShoe {
	@Test(priority=1)
	public void add_new_product()
	{
		
		Response res=RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/add-shoe")
		.queryParam("id","1020")
		.queryParam("image", "www.imge.com")
		.queryParam("name","Nike")
		.queryParam("category", "Running")
		.queryParam("sizes","5,6,7")
		.queryParam("price", "2000")
		.when()
		.post()
		.then()
		.log().all()
		.body("message",Matchers.equalTo("Nike Added Successfully."))
		.body("shoe.id",Matchers.equalTo(1020))
		.body("shoe.name",Matchers.equalTo("Nike"))
		.extract()
		.response();
		int expectedstatuscode=200;
		int Actualstatuscode=res.getStatusCode();
		Assert.assertEquals(expectedstatuscode, Actualstatuscode);;
		
}
	@Test(priority=2)
	public void update_a_product()
	{
		
		Response res=RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/update-shoe")
		.queryParam("id","1020")
		.queryParam("image", "www.imge123.com")
		.queryParam("name","Reebok")
		.queryParam("category", "Running")
		.queryParam("sizes","5,6,7")
		.queryParam("price", "2500")
		.when()
		.put()
		.then()
		.log().all()
		.body("message",Matchers.equalTo("Reebok Updated Successfully."))
		.body("shoe.id",Matchers.equalTo(1020))
		.body("shoe.name",Matchers.equalTo("Reebok"))
		.extract()
		.response();
		
		int expectedstatuscode=200;
		int Actualstatuscode=res.getStatusCode();
		Assert.assertEquals(expectedstatuscode, Actualstatuscode);
				
}
	@Test(priority='3')
	public void delete_product()
	{
		
		Response res=RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/delete-shoe")
		.queryParam("id", "1020")
		.when().delete()
		.then().log().all()
		.body("message",Matchers.equalTo("Shoe with ID 1020 Deleted Successfully."))
		.extract()
		.response();
		int expectedstatuscode=200;
		int Actualstatuscode=res.getStatusCode();
		Assert.assertEquals(expectedstatuscode,Actualstatuscode);	
	}
}