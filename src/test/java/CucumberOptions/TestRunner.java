package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/featureFiles",
glue="stepDefinitions",
tags="@Smoke", plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"html:target/cucumber.html", "json:target/cucumber.json"})
public class TestRunner  extends AbstractTestNGCucumberTests{

}

