package Assignment_22;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SkincareRecommendation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Open Amazon
        driver.get("https://www.amazon.in");

        driver.manage().window().maximize();

        // Search Acne Skin Care Products
        driver.findElement(By.id("twotabsearchtextbox"))
              .sendKeys("acne skin care cleanser serum sunscreen");

        driver.findElement(By.id("twotabsearchtextbox"))
              .sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        // Click First Product
        driver.findElement(By.xpath("(//div[@data-component-type='s-search-result'])[1]"))
              .click();

        Thread.sleep(3000);

        // Add to Cart
        driver.findElement(By.id("add-to-cart-button"))
              .click();

        System.out.println("Skin Care Product Added to Cart");

        Thread.sleep(3000);

        driver.quit();
    }
}