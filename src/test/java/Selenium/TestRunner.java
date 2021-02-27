package Selenium;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)


@CucumberOptions(features = {"src/test/feature/"}, plugin = {"pretty", "html:target/html"}, glue = {"steps"})
public class TestRunner  extends AbstractTestNGCucumberTests {

}
