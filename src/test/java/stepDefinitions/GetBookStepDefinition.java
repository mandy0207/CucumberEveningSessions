package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;

import enums.ApiResources;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.ParseJson;
import utils.ScenarioContext;
import utils.SpecBuildersUtil;

public class GetBookStepDefinition {

	ScenarioContext scenarioContext;
	
	public  GetBookStepDefinition(ScenarioContext scenarioContext) {
		
		this.scenarioContext= scenarioContext;
	}

	@Then("user sends get request to grab book using ID")
	public void user_sends_get_request_to_grab_book_using_id() {
	String bookID=ParseJson.getJsonParser(scenarioContext.getResponse().asString()).get("ID");
	Response getBookResponse=given().spec(SpecBuildersUtil.makeRequestSpec(ApiResources.LibraryURL.getResource(), ContentType.JSON)).queryParam("ID", bookID).when().get(ApiResources.getBook.getResource());
	scenarioContext.setResponse(getBookResponse);
	scenarioContext.setBookID(bookID);	
	}

	@Then("verify user is able to retrive same data sent while creating book")
	public void verify_user_is_able_to_retrive_same_data_sent_while_creating_book() {
		String responseISBN =  (String)ParseJson.getJsonParser(scenarioContext.getResponse().asString()).getList("isbn").get(0);
		String responseAisle = (String) ParseJson.getJsonParser(scenarioContext.getResponse().asString()).getList("aisle").get(0);
		String expectedBookId= responseISBN+responseAisle;
		Assert.assertEquals(scenarioContext.getBookID(), expectedBookId);
	}
}
