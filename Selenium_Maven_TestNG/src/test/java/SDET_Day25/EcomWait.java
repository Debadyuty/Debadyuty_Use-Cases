package SDET_Day25;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class EcomWait {

	public static void main(String[] args)
			throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com");

		Thread.sleep(2000);

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);

		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);

		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);

		// EXPLICIT WAIT
		// WAIT UNTIL ADD TO CART BUTTON CLICKABLE


		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));

		WebElement addToCart =wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));

		System.out.println("Add To Cart Button Clickable");

		Thread.sleep(2000);

		addToCart.click();

		Thread.sleep(2000);

		System.out.println(
				"Product Added To Cart Successfully");

		Thread.sleep(2000);

		driver.quit();
	}
}