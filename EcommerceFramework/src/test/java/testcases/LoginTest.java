package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    LoginPage lp;

    @BeforeMethod
    public void start() {

        setup();

        lp = new LoginPage();
    }

    @Test
    public void validLoginTest() {

        lp.openLoginPage();

        lp.login("test@gmail.com", "test123");

        System.out.println("Login Test Passed");
    }

    @AfterMethod
    public void end() {

        closeBrowser();
    }
}