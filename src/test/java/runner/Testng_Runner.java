package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="resources/features",
		 glue={"stepdefinitions","hooks"},
		 monochrome = true, 
		 publish=true,
		 plugin={"pretty","html:target/CucumberReports/CucumberReport.html",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		 tags="@Smoke"
		
)

public class Testng_Runner extends AbstractTestNGCucumberTests {

	
	/*
	 * @Override
	 * 
	 * @DataProvider(parallel =true) public Object[][] scenarios() { //Extend
	 * Scenarios from supercalss and return it return super.scenarios();
	 * 
	 * }
	 */
	
}