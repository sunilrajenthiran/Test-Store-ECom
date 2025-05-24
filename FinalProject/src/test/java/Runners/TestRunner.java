package Runners;

import org.testng.annotations.Test; 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(
		features = {"src/test/resources/Features"},
		glue = "StepDefinition",
		plugin = {"pretty","html:target/cucumber_reports.html"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE)
		
	@Test	
public class TestRunner extends AbstractTestNGCucumberTests{

}
