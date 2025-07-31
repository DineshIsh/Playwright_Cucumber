package StepDefinition;

import HelperFunctions.JsonHelper;
import POJO.UserDataPOJO;
import Page.LoginPage;
import Utility.BrowserService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LoginStep {

    private static final Logger log = LoggerFactory.getLogger(LoginStep.class);
    LoginPage loginto;
    private  UserDataPOJO userData;

    public LoginStep() {
        JsonHelper jsonHelper = new JsonHelper();
        List<UserDataPOJO> userList = jsonHelper.getUserList("src/test/resources/Data/User.json");

        // Pick the first user from the list (index 0) – or apply logic to choose
        userData = userList.get(0);
    }


    @Given("login sceario")
    public void loginSceario() throws InterruptedException {
        log.info("Its initiated ");
        BrowserService.initBrowser();
        loginto = LoginPage.getInstance(BrowserService.page);
        System.out.println(userData.getProductName() + "Check the console for the name ");
        loginto.clickSignIn(userData.getProductName());
        log.debug("this 1st step over ");
    }


    @When("I enter the username")
    public void iEnterTheUsername() {
    }

    @And("I enter the pasword")
    public void iEnterThePasword() {
    }

    @Then("I validate the username and password")
    public void iValidateTheUsernameAndPassword() {
    }
}
