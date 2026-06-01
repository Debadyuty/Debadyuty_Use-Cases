package Maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMSAutomation {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        
        // Launch Browser
        WebDriver driver = new ChromeDriver();

        // Open HRMS Website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Maximize Window
        driver.manage().window().maximize();

        Thread.sleep(2000);

        // ================= ADMIN LOGIN =================

        driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        // ================= ADD EMPLOYEE =================

        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("firstName")).sendKeys("Deba");

        driver.findElement(By.name("lastName")).sendKeys("Gayen");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        // ================= SEARCH EMPLOYEE =================

        driver.findElement(By.xpath("//a[text()='Employee List']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"))
              .sendKeys("Deba");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        // ================= UPDATE EMPLOYEE =================

        driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("middleName")).sendKeys("Kumar");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        // ================= DELETE EMPLOYEE =================

        driver.findElement(By.xpath("//a[text()='Employee List']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();

        Thread.sleep(3000);

        // Close Browser
        driver.quit();
    }
}