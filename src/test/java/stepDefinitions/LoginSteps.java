package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utils.DriverFactory;

public class LoginSteps {
    private WebDriver driver = DriverFactory.getDriver("chrome");
    private LoginPage loginPage = new LoginPage(driver);

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters valid credentials {string} and {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("the user should see the dashboard")
    public void userShouldSeeDashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard is not displayed!");
    }
}
