package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/featureFiles",
glue="stepDefinitions",
tags="@Sanity")
public class TestRunner  extends AbstractTestNGCucumberTests{

}
