package stepDefinition;

import Pages.Google;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitionLoginout {

    Google page_google = new Google();

    @Given("the new user navigates to the e-commerce web")
    public void the_new_user_navigates_to_the_e_commerce_web() {
        page_google.launchBrowser();
        page_google.openDemoPage();
        page_google.maximize();

    }
    @And("is on log in page")
    public void is_on_log_in_page() throws InterruptedException {
        page_google.clickLogInButtonNav();
    }
    @When("the new user enter {string} as a username")
    public void the_new_user_enter_as_a_username(String string) throws InterruptedException {
        page_google.enterUsername(string,"login");

    }
    @And("the new user enter a {string} as a password")
    public void the_new_user_enter_a_as_a_password(String string) throws InterruptedException {
        page_google.enterPassword(string, "login");

    }
    @And("the new user clicks on the log in button")
    public void the_new_user_clicks_on_the_log_in_button() throws InterruptedException {
        page_google.clickSubmitButton("login");

    }
    @Then("the new user watch the welcome text in the nav")
    public void the_new_user_watch_the_welcome_text_in_the_nav() throws Exception {
        page_google.detectWelcome();

    }
    @And("the new user click on the log out button")
    public void the_new_user_click_on_the_log_out_button() {
        page_google.userLogOut();

    }


}
