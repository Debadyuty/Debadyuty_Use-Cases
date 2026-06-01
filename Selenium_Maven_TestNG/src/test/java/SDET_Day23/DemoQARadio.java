package SDET_Day23;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class DemoQARadio {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://demoqa.com/radio-button");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	WebElement element;
	element = driver.findElement(By.id("yesRadio"));
	element.click();
	System.out.println("Yes clicked");
	Thread.sleep(2000);
	element = driver.findElement(By.id("impressiveRadio"));
	element.click();
	System.out.println("Impressive clicked");
	Thread.sleep(2000);
	driver.quit();
}
}
