package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinitionLogin {

    @Given("^User is on login page$")
    public void user_is_on_login_page() throws Throwable {
        System.out.println("Testing");
    }

    @When("^User enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userEntersUsernameAndPassword(String arg0, String arg1) throws Throwable {
        System.out.println("Testing");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        System.out.println("Testing");
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() throws Throwable {
        System.out.println("Testing");
    }
}