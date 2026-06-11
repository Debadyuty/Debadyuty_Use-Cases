package stepdefinition;

//package StepDefinitions;

import BasePackage.BaseClass;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginsteps extends BaseClass {

    WebDriverWait wait;

    @Given("user launches browser")
    public void launch_browser() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("Browser launched successfully");
    }

    @Given("user opens login page")
    public void open_login_page() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Login page opened");
    }

    @When("user enters username {string}")
    public void enter_username(String username) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys(username);
    }

    @When("user enters password {string}")
    public void enter_password(String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("user clicks login button")
    public void click_login_button() {

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user should navigate to dashboard")
    public void navigate_dashboard() {

        wait.until(ExpectedConditions.urlContains("dashboard"));
        System.out.println("Dashboard displayed");
    }
    @Then("user should see error message")
    public void error_message() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        String error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")))
                .getText();

        System.out.println("Error Message: " + error);
    }
}