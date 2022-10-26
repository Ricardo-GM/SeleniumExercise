package stepDefinition;

import Pages.Google;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitionSignup {
    Google page_google = new Google();

    @Given("^the new user navigates to the ecommerce web$")
    public void the_new_user_navigates_to_the_ecommerce_web() {
        page_google.launchBrowser();
        page_google.openDemoPage();
        page_google.maximize();

    }
    @And("^is on sign up page$")
    public void is_on_sign_up_page() throws InterruptedException {
        page_google.clickSignUpButtonNav();

    }
    @When("^the new user enter a valid and unique username$")
    public void the_new_user_enter_a_valid_and_unique_username() throws InterruptedException {
        page_google.enterUsername("Baufest28888", "register");

    }
    @And("^the new user enter a valid and unique password$")
    public void the_new_user_enter_a_valid_and_unique_password() throws InterruptedException {
        page_google.enterPassword("Contra123457", "register");

    }
    @And("^the new user clicks on the sign up button$")
    public void the_new_user_clicks_on_the_sign_up_button() throws InterruptedException {
        page_google.clickSubmitButton("register");
        Thread.sleep(500);

    }
    @Then("^the new user watch an successful registration message$")
    public void the_new_user_watch_an_successful_registration_message() throws Exception {
        page_google.detectSuccesfullyAlert();
    }



}
