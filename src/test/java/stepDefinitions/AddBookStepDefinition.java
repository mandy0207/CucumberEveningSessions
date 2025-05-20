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
import utils.SpecBuildersUtil;
import utils.UniqueGenerator;

public class AddBookStepDefinition {
	Response response;
	String baseUrl;

	@Given("library baseURL is available")
	public void library_base_url_is_available() {
		baseUrl = ApiResources.LibraryURL.getResource();
	}

	@When("user sends post request to add book with unique creds")
	public void user_sends_post_request_to_add_book_with_unique_creds() {
		response = given().spec(SpecBuildersUtil.makeRequestSpec(baseUrl, ContentType.JSON))
				.body(UniqueGenerator.getBook()).when().post(ApiResources.postBook.getResource()).then().log().all()
				.extract().response();
	}

	@When("user sends post request to add book with {string} {string} {string} {string}")
	public void user_sends_post_request_to_add_book_with(String bookName, String isbn, String aisle, String author) {
		Book book = new Book(bookName, isbn, aisle + Integer.toString(UniqueGenerator.getRandomNumber()), author);
		response = given().spec(SpecBuildersUtil.makeRequestSpec(baseUrl, ContentType.JSON)).body(book).when()
				.post(ApiResources.postBook.getResource()).then().log().all().extract().response();
	}

	@Then("the status code should be {string}")
	public void the_status_code_should_be(String statusCode) {
		response.then().assertThat().statusCode(Integer.parseInt(statusCode));
	}

	@Then("response should contain message {string}")
	public void response_should_contain_message(String expectedMsg) {
		response.then().assertThat().body("Msg", equalTo(expectedMsg));

	}

}
