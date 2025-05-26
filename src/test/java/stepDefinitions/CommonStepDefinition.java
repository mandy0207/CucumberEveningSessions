package stepDefinitions;

import enums.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.ScenarioContext;

public class CommonStepDefinition {
	ScenarioContext scenarioContext;
	
	public CommonStepDefinition(ScenarioContext scenarioContext) {
		this.scenarioContext= scenarioContext;
	}
	
	
	@Given("library baseURL is available")
	public void library_base_url_is_available() {
		scenarioContext.setBaseUrl(ApiResources.LibraryURL.getResource());
		
	}	
	
	@Then("the status code should be {string}")
	public void the_status_code_should_be(String statusCode) {
		scenarioContext.getResponse().then().assertThat().statusCode(Integer.parseInt(statusCode));
	}
}
