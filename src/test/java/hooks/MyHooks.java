package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {

    WebDriver driver;


    @Before
    public void setup() {

        Properties prop = new ConfigReader().intializeProperties();
        String sysBrowser = System.getProperty("browser");
        String browser = (sysBrowser != null && !sysBrowser.isEmpty())
                ? sysBrowser
                : prop.getProperty("browser", "chrome");

        String sysUrl = System.getProperty("url");
        String url = (sysUrl != null && !sysUrl.isEmpty())
                ? sysUrl
                : prop.getProperty("url", "url");

        driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));

    }

    @After
    public void tearDown(Scenario scenario) {

        //if (driver != null) {
        String scenarioName = scenario.getName().replaceAll(" ", "_");

        if (scenario.isFailed()) {

            byte[] srcScreenshot =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcScreenshot, "image/png", scenarioName);
        }

        driver.quit();
    }
    //}

}
