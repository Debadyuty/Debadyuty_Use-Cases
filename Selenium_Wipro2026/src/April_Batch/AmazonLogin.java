package April_Batch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLogin {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		Thread.sleep(3000);

		// Click Sign In
		driver.findElement(By.id("nav-link-accountList")).click();

		Thread.sleep(3000);

		// Enter Email
		driver.findElement(By.id("ap_email"))
			  .sendKeys("8582859898");

		Thread.sleep(2000);

		// Click Continue
		driver.findElement(By.id("continue")).click();

		// IMPORTANT WAIT
		Thread.sleep(5000);

		// Enter Password
		driver.findElement(By.id("ap_password"))
			  .sendKeys("Deba_12345");

		Thread.sleep(2000);

		// Click Sign In
		driver.findElement(By.id("signInSubmit")).click();

		Thread.sleep(5000);

		System.out.println(driver.getTitle());

		driver.quit();
	}
}