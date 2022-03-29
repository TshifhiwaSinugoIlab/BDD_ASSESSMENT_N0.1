package Automation.features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(value = Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Automation/features",
        tags = {"@run1","~@ignore"},
        glue={"Automation.stepDefinition"},
        plugin = { "pretty", "html:target/cucumber-reports" },
        monochrome = true
)

public class TestRunner {

}
