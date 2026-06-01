package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    By myAccount =
            By.xpath("//span[text()='My Account']");

    By login =
            By.linkText("Login");

    By email =
            By.id("input-email");

    By password =
            By.id("input-password");

    By loginBtn =
            By.xpath("//button[contains(text(),'Login')]");

    public void login(String user, String pass) {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions
                .elementToBeClickable(myAccount)).click();

        driver.findElement(login).click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(email));

        driver.findElement(email).sendKeys(user);

        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }
}