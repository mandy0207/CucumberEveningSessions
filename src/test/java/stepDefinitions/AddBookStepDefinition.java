package stepDefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import enums.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.Book;
import utils.ParseJson;
import utils.UniqueGenerator;

public class AddBookStepDefinition {
	Response response;
	
	@Given("library baseURL is available")
	public void library_base_url_is_available() {
		RestAssured.baseURI = ApiResources.LibraryURL.getResource();
	}
	@When("user sends post request to add book with unique creds")
	public void user_sends_post_request_to_add_book_with_unique_creds() {
		String isbn = UniqueGenerator.getFaker().name().firstName();
		String aisle = Integer.toString(UniqueGenerator.getRandomNumber());
		String author= UniqueGenerator.getFaker().book().author();
		String bookName= UniqueGenerator.getFaker().book().title();
		Book book = new Book(bookName, isbn, aisle, author);
		
		response=given().log().all().header("Content-Type", "application/json")
				.body(book).when().post(ApiResources.postBook.getResource()).then().log().all().extract().response();
	}
	
	@Then("the status code should be {string}")
	public void the_status_code_should_be(String statusCode) {
		int statusCodeValue=response.getStatusCode();
		Assert.assertEquals(Integer.toString(statusCodeValue), statusCode);
	}
	@Then("response should contain message {string}")
	public void response_should_contain_message(String expectedMsg) {
		String actualMsg=ParseJson.getJsonParser(response.asString()).get("Msg");
		Assert.assertEquals(actualMsg, expectedMsg); 
	}


}
