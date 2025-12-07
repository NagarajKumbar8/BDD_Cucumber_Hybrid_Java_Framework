package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="resources/features",
		 glue={"stepdefinitions","hooks"},
		 monochrome = true, 
		 publish=true,
		 plugin={"pretty","html:target/CucumberReports/CucumberReport.html"},
		 tags="@Smoke"
		
)

public class Testng_Runner extends AbstractTestNGCucumberTests {

	
	
}
