package steps;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class ProjectSteps {

@Given("User sends a Get Request to get all the product details")
public void user_sends_a_get_request_to_get_all_the_product_details() {
    // Write code here that turns the phrase above into concrete actions
	RestAssured.given()
	.baseUri("http://localhost:9010/")
	.basePath("/get-shoes")
	.when().get()
	.then().statusCode(200).log().all();
}

@Given("User sends a Get Request to get all the user details")
public void user_sends_a_get_request_to_get_all_the_user_details() {
    // Write code here that turns the phrase above into concrete actions
	RestAssured.given()
	.baseUri("http://localhost:9010/")
	.basePath("/get-users")
	.when().get()
	.then().statusCode(200).log().all();
}

@Given("User sends a Post Request to add the product")
public void user_sends_a_post_request_to_add_the_product() {
    // Write code here that turns the phrase above into concrete actions
	RestAssured.given()
	.baseUri("http://localhost:9010/")
	.basePath("/add-shoe")
	.queryParam("id","1020")
	.queryParam("image", "www.imge.com")
	.queryParam("name","Nike")
	.queryParam("category", "Running")
	.queryParam("sizes","5,6,7")
	.queryParam("price", "2000")
	.when().post()
	.then().statusCode(200).log().all();
}

@Given("User sends a Put Request to update the product")
public void user_sends_a_put_request_to_update_the_product() {
    // Write code here that turns the phrase above into concrete actions
	RestAssured.given()
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
	.log().all();
}

@Given("User sends a Delete Request to delete the product")
public void user_sends_a_delete_request_to_delete_the_product() {
    // Write code here that turns the phrase above into concrete actions

	RestAssured.given()
	.baseUri("http://localhost:9010")
	.basePath("/delete-shoe")
	.queryParam("id", "1020")
	.when().delete()
	.then().log().all();	
}

}
