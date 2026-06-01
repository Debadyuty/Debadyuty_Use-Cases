package SDET_Day25;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightWait {

	public static void main(String[] args)throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.get("https://blazedemo.com");

		Thread.sleep(2000);

		WebElement fromCity =driver.findElement(By.name("fromPort"));

		Select from =new Select(fromCity);

		from.selectByVisibleText("Paris");

		Thread.sleep(2000);


		WebElement toCity =driver.findElement(By.name("toPort"));

		Select to =new Select(toCity);

		to.selectByVisibleText("London");

		Thread.sleep(2000);


		// EXPLICIT WAIT
		// WAIT FOR BUTTON CLICKABLE


		WebDriverWait explicitWait =new WebDriverWait(driver,Duration.ofSeconds(20));

		WebElement searchBtn =explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Find Flights']")));

		System.out.println("Search Button Clickable");

		Thread.sleep(2000);

		searchBtn.click();

		Thread.sleep(2000);

		Wait<WebDriver> fluentWait =
				new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))    				// FLUENT WAIT
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);

		WebElement resultTable =
				fluentWait.until(driver1 ->
				driver1.findElement(
						By.xpath("//table")));

		Thread.sleep(2000);

		System.out.println(
				"Flights Loaded Successfully");

		Thread.sleep(2000);

		driver.quit();
	}
}