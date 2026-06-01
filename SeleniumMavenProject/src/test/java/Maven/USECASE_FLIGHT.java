package Maven;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class USECASE_FLIGHT {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://phptravels.net/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acknowledgeDemoWarning"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/header/div[1]/div/div[2]/div[2]/button"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/header/div[1]/div/div[2]/div[2]/div[2]/div/a[7]"))).click();
        System.out.println("Login Done");

        WebElement flightTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//button[@role='tab'])[3]")));
        flightTab.click();
      

        WebElement from = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@x-ref='fromInput']")));
        from.click();
        from.sendKeys("Delhi");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'Delhi')]"))).click();
        System.out.println("From: Delhi");

        WebElement to = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@x-ref='toInput']")));
        to.click();
        to.sendKeys("Mumbai");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'Mumbai')]"))).click();
        System.out.println("To: Mumbai");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.name("flights_departure_date"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[7]/div[1]/table/tbody/tr[5]/td[4]/div"))).click();
       

    
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='passengers']/following-sibling::div"))).click();
     

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div[3]/div/div/div[3]/div/div/form/div[3]/div[3]/button"))).click();
     

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div[3]/div/main/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div[4]/button"))).click();
        System.out.println("Flight Search Done");

        Thread.sleep(5000);

        driver.quit();
        System.out.println("Booking Done");
    }
}