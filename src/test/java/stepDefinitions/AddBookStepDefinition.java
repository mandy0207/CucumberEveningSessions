package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import enums.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Book;
import utils.ParseJson;
import utils.ScenarioContext;
import utils.SpecBuildersUtil;
import utils.UniqueGenerator;

public class AddBookStepDefinition {
	
	
	ScenarioContext scenarioContext;

	
	public  AddBookStepDefinition(ScenarioContext scenarioContext) {
		this.scenarioContext= scenarioContext;
	
	}
	

	@When("user sends post request to add book with unique creds")
	public void user_sends_post_request_to_add_book_with_unique_creds() {
		Response addBookResponse = given().spec(SpecBuildersUtil.makeRequestSpec(scenarioContext.getBaseUrl(), ContentType.JSON))
				.body(UniqueGenerator.getBook()).when().post(ApiResources.postBook.getResource()).then().log().all()
				.extract().response();
		scenarioContext.setResponse(addBookResponse);
	
	}
	
	@When("user sends post request to add book with {string} {string} {string} {string}")
	public void user_sends_post_request_to_add_book_with(String bookName, String isbn, String aisle, String author) {
		Book book = new Book(bookName, isbn, aisle + Integer.toString(UniqueGenerator.getRandomNumber()), author);
		Response addBookResponse  = given().spec(SpecBuildersUtil.makeRequestSpec(scenarioContext.getBaseUrl(), ContentType.JSON)).body(book).when()
				.post(ApiResources.postBook.getResource()).then().log().all().extract().response();
		
		scenarioContext.setResponse(addBookResponse);
	}


	@Then("response should contain message {string}")
	public void response_should_contain_message(String expectedMsg) {
		scenarioContext.getResponse().then().assertThat().body("Msg", equalTo(expectedMsg));

	}

}
