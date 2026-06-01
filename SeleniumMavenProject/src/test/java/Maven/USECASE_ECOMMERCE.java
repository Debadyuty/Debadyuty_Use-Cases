package Maven;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class USECASE_ECOMMERCE {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();

		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(500);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(500);

		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);

		
		try {
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("Popup dismissed via Enter key");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Popup not found or already dismissed: " + e.getMessage());
		}

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
		

		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("item_4_title_link")));
		driver.findElement(By.id("item_4_title_link")).click();
		Thread.sleep(2000);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='add-to-cart']")));
		driver.findElement(By.xpath("//*[@id='add-to-cart']")).click();
		Thread.sleep(1500);
		System.out.println("Added to cart");

		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='shopping_cart_container']/a")));
		driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
		Thread.sleep(1500);
		

		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='checkout']")));
		driver.findElement(By.xpath("//*[@id='checkout']")).click();
		Thread.sleep(1500);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));

		driver.findElement(By.id("first-name")).sendKeys("Debadyuty");
		Thread.sleep(500);
	

		driver.findElement(By.id("last-name")).sendKeys("Gayen");
		Thread.sleep(500);
		

		driver.findElement(By.id("postal-code")).sendKeys("700061");
		Thread.sleep(500);
		

		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='continue']")));
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		Thread.sleep(5000);

		 driver.quit(); 
	}

}