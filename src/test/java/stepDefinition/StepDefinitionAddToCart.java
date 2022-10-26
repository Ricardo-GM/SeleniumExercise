package stepDefinition;

import Pages.Google;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitionAddToCart {
    Google page_google = new Google();

    @Given("the user login on the e-commer web succesfully")
    public void the_user_login_on_the_e_commer_web_succesfully() throws Throwable {
        page_google.logIn();
    }

    @When("the user clicks on the Laptops Category")
    public void the_user_clicks_on_the_Laptops_Category() throws Throwable {
        page_google.enterLaptopCategory();

    }

    @And("the user adds the first item listed to the shopping cart")
    public void the_user_adds_the_first_item_listed_to_the_shopping_cart() throws Throwable {
        page_google.AddFirstLaptopToCart();

    }

    @Then("the user see the item added on the shopping cart")
    public void the_user_see_the_item_added_on_the_shopping_cart() throws Throwable {
        page_google.clickCartButtonNav();
        page_google.detectItem();

    }

    @And("the user log out of the e-commerce web")
    public void the_user_log_out_of_the_e_commerce_web() throws Throwable {
        page_google.userLogOut();

    }
}
