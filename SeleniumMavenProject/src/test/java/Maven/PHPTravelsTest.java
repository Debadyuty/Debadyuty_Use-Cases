package Maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class PHPTravelsTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        

        // Launch Browser
        WebDriver driver = new ChromeDriver();

        // Open Website
        driver.get("https://phptravels.net/");

        // Maximize Window
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // Click My Account
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

        // Click Signup
        driver.findElement(By.xpath("//a[contains(text(),'Signup')]")).click();

        Thread.sleep(2000);

        // Registration Form
        driver.findElement(By.name("first_name")).sendKeys("Deba");

        driver.findElement(By.name("last_name")).sendKeys("Gayen");

        driver.findElement(By.name("phone")).sendKeys("9876543210");

        driver.findElement(By.name("email")).sendKeys("deba@gmail.com");

        driver.findElement(By.name("password")).sendKeys("deba@123");

        // Click Signup Button
        driver.findElement(By.xpath("//button[contains(text(),'Signup')]")).click();

        Thread.sleep(3000);

        // Flight Search
        driver.findElement(By.xpath("//input[@placeholder='Flying From']")).sendKeys("Kolkata");

        driver.findElement(By.xpath("//input[@placeholder='To Destination']")).sendKeys("Delhi");

        Thread.sleep(3000);

        // Close Browser
        driver.quit();
    }
}