package Maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParaBankRegisterTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        

        // Launch Browser
        WebDriver driver = new ChromeDriver();

        // Open ParaBank Website
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        // Maximize Window
        driver.manage().window().maximize();

        Thread.sleep(2000);

        // Enter Registration Details
        driver.findElement(By.id("customer.firstName")).sendKeys("Debadyuty");

        driver.findElement(By.id("customer.lastName")).sendKeys("Gayen");

        driver.findElement(By.id("customer.address.street")).sendKeys("Kolkata");

        driver.findElement(By.id("customer.address.city")).sendKeys("Kolkata");

        driver.findElement(By.id("customer.address.state")).sendKeys("West Bengal");

        driver.findElement(By.id("customer.address.zipCode")).sendKeys("700001");

        driver.findElement(By.id("customer.phoneNumber")).sendKeys("8582859898");

        driver.findElement(By.id("customer.ssn")).sendKeys("123456");

        driver.findElement(By.id("customer.username")).sendKeys("deba123");

        driver.findElement(By.id("customer.password")).sendKeys("deba@123");

        driver.findElement(By.id("repeatedPassword")).sendKeys("deba@123");

        // Click Register Button
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        Thread.sleep(3000);

        // Close Browser
        driver.quit();
    }
}