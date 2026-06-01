package Assignment_22;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeadphonesAutomation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Open Amazon
        driver.get("https://www.amazon.in");

        driver.manage().window().maximize();

        // Search Product
        driver.findElement(By.id("twotabsearchtextbox"))
              .sendKeys("wireless headphones");

        driver.findElement(By.id("twotabsearchtextbox"))
              .sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        // Apply Brand Filter (Example: boAt)
        driver.findElement(By.xpath("//span[text()='boAt']"))
              .click();

        Thread.sleep(3000);

        // Open First Product
        driver.findElement(By.xpath("(//div[@data-component-type='s-search-result'])[1]"))
              .click();

        Thread.sleep(3000);

        // Add to Cart
        driver.findElement(By.id("add-to-cart-button"))
              .click();

        System.out.println("Headphones Added to Cart");

        Thread.sleep(3000);

        driver.quit();
    }
}