package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass {

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

    public void openLoginPage() {

        driver.findElement(myAccount).click();

        driver.findElement(login).click();
    }

    public void login(String mail, String pass) {

        driver.findElement(email).sendKeys(mail);

        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }
}