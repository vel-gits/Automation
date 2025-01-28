package com.example.stepdefinitions;

import com.example.Utliz.DriverFactory;
import com.example.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private WebDriver driver = DriverFactory.getDriver("chrome");
    private LoginPage loginPage = new LoginPage(driver);

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://example.com/login");
    }

    @When("I enter valid credentials {string} and {string}")
    public void iEnterValidCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("I should see the dashboard")
    public void iShouldSeeTheDashboard() {
        assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @When("I enter invalid credentials {string} and {string}")
    public void iEnterInvalidCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assertTrue(driver.getPageSource().contains("Invalid credentials"));
    }
}
