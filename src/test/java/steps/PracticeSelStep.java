package steps;

import Actions.PracticeSelActions;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.AfterClass;

public class PracticeSelStep {

    PracticeSelActions actions=new PracticeSelActions();
    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {
        actions.initialiseDriver();
        actions.navigateTo(url);

    }

    @When("User selects {string} as a {string}")
    public void userSelectsAsA(String value, String type) {
        actions.selectTheWebElementForTheGivenValue(value,type);
    }

    @Then("User clicks on login")
    public void userClicksOnLogin() {
        actions.clickOnLogin();
    }

    @Then("User opens a new Tab and navigates to {string}")
    public void userOpensANewTabAndNavigatesTo(String url) {
        actions.openNewTabAndNavigate(url);
    }


    @AfterClass
    public static void tearDown() {
 ExtentService.getInstance().flush();
//ExtentService.getInstance().
    }

}