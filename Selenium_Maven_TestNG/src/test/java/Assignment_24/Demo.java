package Assignment_24;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Demo {

	public static void main(String[] args) throws InterruptedException, IOException {

		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions act = new Actions(driver);

		

		driver.get("https://demoqa.com/automation-practice-form");

		
		driver.findElement(By.id("firstName")).sendKeys("Debadyuty");

		driver.findElement(By.id("lastName")).sendKeys("Gayen");

		driver.findElement(By.id("userEmail")).sendKeys("debadyuty@gmail.com");

		System.out.println("Text Fields Entered Successfully");

		WebElement gender = driver.findElement(By.xpath("//label[text()='Male']"));

		gender.click();

		System.out.println("Radio Button Selected");

		driver.findElement(By.id("userNumber")).sendKeys("8582859898");

		
		WebElement sports = driver.findElement(By.xpath("//label[text()='Sports']"));

		sports.click();

		System.out.println("Checkbox Selected");

		

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(2000);

		System.out.println("Page Scrolled Successfully");

		

		driver.navigate().to("https://demoqa.com/select-menu");

		
		WebElement oldStyleMenu = driver.findElement(By.id("oldSelectMenu"));

		Select select = new Select(oldStyleMenu);

		select.selectByVisibleText("Blue");

		System.out.println("Dropdown Selected Successfully");

		

		driver.navigate().to("https://demoqa.com/broken");

		WebElement image = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));

		if (image.isDisplayed()) {

			System.out.println("Image Displayed Successfully");
		}

	

		driver.navigate().to("https://demoqa.com/buttons");

		
		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

		act.doubleClick(doubleClickBtn).perform();

		System.out.println("Double Click Performed");

		WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));

		act.contextClick(rightClickBtn).perform();

		System.out.println("Right Click Performed");

		WebElement dynamicClick = driver.findElement(By.xpath("//button[text()='Click Me']"));

		dynamicClick.click();

		System.out.println("Dynamic Click Performed");

		

		driver.navigate().to("https://demoqa.com/menu");

		WebElement mainItem = driver.findElement(By.xpath("//a[text()='Main Item 2']"));

		act.moveToElement(mainItem).perform();

		System.out.println("Mouse Hover Performed");

		Thread.sleep(2000);

		

		driver.navigate().to("https://demoqa.com/droppable");

		WebElement source = driver.findElement(By.id("draggable"));

		WebElement target = driver.findElement(By.id("droppable"));

		act.dragAndDrop(source, target).perform();

		System.out.println("Drag And Drop Performed");

		Thread.sleep(2000);

		

		driver.navigate().to("https://demoqa.com/slider");

		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

		act.dragAndDropBy(slider, 50, 0).perform();

		System.out.println("Slider Handled Successfully");

		Thread.sleep(2000);

	
		driver.navigate().to("https://demoqa.com/alerts");

		
		driver.findElement(By.id("alertButton")).click();

		Alert alert1 = driver.switchTo().alert();

		System.out.println(alert1.getText());

		alert1.accept();

		System.out.println("Simple Alert Handled");

		Thread.sleep(2000);

	
		driver.findElement(By.id("confirmButton")).click();

		Alert alert2 = driver.switchTo().alert();

		System.out.println(alert2.getText());

		alert2.dismiss();

		System.out.println("Confirmation Alert Handled");

		Thread.sleep(2000);

		driver.findElement(By.id("promtButton")).click();

		Alert alert3 = driver.switchTo().alert();

		alert3.sendKeys("Shaurya");

		alert3.accept();

		System.out.println("Prompt Alert Handled");

		Thread.sleep(2000);

		

		TakesScreenshot ts = (TakesScreenshot) driver;

		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		File destination = new File("screenshot.png");

		java.nio.file.Files.copy(
				sourceFile.toPath(),
				destination.toPath(),
				java.nio.file.StandardCopyOption.REPLACE_EXISTING);

		System.out.println("Screenshot Taken Successfully");

		

		Thread.sleep(3000);

		driver.quit();

		System.out.println("Automation Completed Successfully");
	}
}
