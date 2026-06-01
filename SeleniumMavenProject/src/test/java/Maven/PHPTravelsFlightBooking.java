package Maven;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PHPTravelsFlightBooking {

	public static void main(String[] args) throws InterruptedException {

		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open PHP Travels Website
		driver.get("https://phptravels.net/");
		Thread.sleep(5000);

		// Click on Flights Menu
		driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();
		Thread.sleep(4000);

		// =========================
		// SELECT SOURCE CITY
		// =========================

		WebElement fromCity = driver.findElement(By.xpath("(//input[@type='search'])[1]"));
		fromCity.click();
		Thread.sleep(2000);

		fromCity.sendKeys("Delhi");
		Thread.sleep(3000);

		fromCity.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);

		fromCity.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// =========================
		// SELECT DESTINATION CITY
		// =========================

		WebElement toCity = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
		toCity.click();
		Thread.sleep(2000);

		toCity.sendKeys("Mumbai");
		Thread.sleep(3000);

		toCity.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);

		toCity.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// =========================
		// SELECT JOURNEY DATE
		// =========================

		driver.findElement(By.id("departure")).click();
		Thread.sleep(2000);

		// Select date from calendar
		driver.findElement(By.xpath("//div[@class='day ' and text()='25']")).click();
		Thread.sleep(3000);

		// =========================
		// SELECT PASSENGERS
		// =========================

		driver.findElement(By.id("fadults")).click();
		Thread.sleep(2000);

		// Increase adult passengers
		driver.findElement(By.xpath("(//i[@class='la la-plus'])[1]")).click();
		Thread.sleep(2000);

		// =========================
		// SEARCH FLIGHTS
		// =========================

		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		Thread.sleep(8000);

		// =========================
		// SELECT FIRST AVAILABLE FLIGHT
		// =========================

		driver.findElement(By.xpath("(//button[contains(text(),'Book Now')])[1]")).click();
		Thread.sleep(8000);

		// =========================
		// ENTER PASSENGER DETAILS
		// =========================

		driver.findElement(By.name("first_name_1")).sendKeys("Debadyuty");
		Thread.sleep(1000);

		driver.findElement(By.name("last_name_1")).sendKeys("Gayen");
		Thread.sleep(1000);

		driver.findElement(By.name("email_1")).sendKeys("debadyutygayen@gmail.com");
		Thread.sleep(1000);

		driver.findElement(By.name("phone_1")).sendKeys("8582859898");
		Thread.sleep(1000);

		// =========================
		// CONFIRM BOOKING
		// =========================

		driver.findElement(By.xpath("//button[contains(text(),'Confirm Booking')]")).click();
		Thread.sleep(10000);

		// =========================
		// VALIDATE BOOKING ID
		// =========================

		String bookingID = driver.findElement(By.xpath("//strong[contains(text(),'Booking ID')]")).getText();

		System.out.println("Booking Successful");
		System.out.println("Booking Details: " + bookingID);

		// =========================
		// CLOSE BROWSER
		// =========================

		driver.quit();
	}
}