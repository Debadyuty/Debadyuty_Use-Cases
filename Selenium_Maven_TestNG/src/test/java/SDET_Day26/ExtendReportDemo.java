package SDET_Day26;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportDemo {

    WebDriver driver;

    ExtentSparkReporter spark;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void startReport() {

        // Report location
        spark = new ExtentSparkReporter("ExtentReport.html");

        // Create ExtentReports object
        extent = new ExtentReports();

        // Attach reporter
        extent.attachReporter(spark);
    }

    @Test
    public void loginTest() throws InterruptedException {

        // Create test
        test = extent.createTest("Login Test");

        driver = new ChromeDriver();

        test.log(Status.INFO, "Chrome Browser Opened");

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        test.log(Status.INFO, "Website Opened");

        // Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        test.pass("Username Entered");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        test.pass("Password Entered");

        // Click Login
        driver.findElement(By.id("login-button")).click();

        test.pass("Login Button Clicked");

        Thread.sleep(3000);

        // Validation
        String title = driver.getTitle();

        if(title.contains("Swag")) {
            test.pass("Login Successful");
        }
        else {
            test.fail("Login Failed");
        }

        driver.quit();
    }

    @AfterTest
    public void tearDown() {

        // Write everything to report
        extent.flush();

        System.out.println("Extent Report Generated");
    }
}
 