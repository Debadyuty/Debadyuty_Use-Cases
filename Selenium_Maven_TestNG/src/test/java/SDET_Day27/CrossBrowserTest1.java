package SDET_Day27;
import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
 
public class CrossBrowserTest1 {
 
	WebDriver driver;
 
	@Parameters("browser")
	@Test
	public void loginTest(String browser) throws InterruptedException, MalformedURLException {
 
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
 
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
 
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		} else {
			System.out.println("Invalid browser parameter");
			return;
		}
 
		driver.manage().window().maximize();
 
		driver.get("https://www.saucedemo.com/");
 
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
 
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("inventory.html")) {
			System.out.println(browser + " -> Login Successful");
		} else {
			System.out.println(browser + " -> Login Failed");
		}
 
		Thread.sleep(20000);
		driver.quit();
	}
}