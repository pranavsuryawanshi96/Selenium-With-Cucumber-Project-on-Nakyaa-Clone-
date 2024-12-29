package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = { 
				"src/test/resources/features/Login.feature",
		        "src/test/resources/features/Search.feature",
			"src/test/resources/features/purchase.feature"
		}, 
		glue = "StepDefination", 
		dryRun = false, 
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
//		plugin = { "pretty","html:target/cucumber-reports/cucumber.html"}, 
		tags = "@regression",
		monochrome = true, publish = true
		)

public class Runner extends AbstractTestNGCucumberTests {
	
}

