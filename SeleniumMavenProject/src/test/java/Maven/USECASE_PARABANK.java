package Maven;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class USECASE_PARABANK{

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.firstName")));

        driver.findElement(By.id("customer.firstName")).sendKeys("Debadyuty");
        driver.findElement(By.id("customer.lastName")).sendKeys("Gayen");
        driver.findElement(By.id("customer.address.street")).sendKeys("Kolkata");
        driver.findElement(By.id("customer.address.city")).sendKeys("Kolkata");
        driver.findElement(By.id("customer.address.state")).sendKeys("West Bengal");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("700061");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("8582859898");
        driver.findElement(By.id("customer.ssn")).sendKeys("10010927364");
        System.out.println("Filled Personal Info");

        driver.findElement(By.id("customer.username")).sendKeys("Debadyuty_24");
        driver.findElement(By.id("customer.password")).sendKeys("Deba@123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Deba@123");
        System.out.println("Filled Credentials");

        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
        Thread.sleep(2000);
        System.out.println("Registration Complete!");

       

        driver.findElement(By.linkText("Log Out")).click();
        Thread.sleep(1500);
       


        driver.findElement(By.name("username")).sendKeys("Debadyuty_24");
        driver.findElement(By.name("password")).sendKeys("Deba@123");
        driver.findElement(By.xpath("//*[@id='loginPanel']/form/div[3]/input")).click();
        Thread.sleep(2000);
      


        driver.findElement(By.linkText("Transfer Funds")).click();
        Thread.sleep(2000);
       

        driver.findElement(By.id("amount")).sendKeys("500");
        Thread.sleep(500);
        

        Select fromAccount = new Select(driver.findElement(By.id("fromAccountId")));
        fromAccount.selectByIndex(0);
        System.out.println("From Account Selected: " + fromAccount.getFirstSelectedOption().getText());

        Select toAccount = new Select(driver.findElement(By.id("toAccountId")));
        toAccount.selectByIndex(0);
        System.out.println("To Account Selected: " + toAccount.getFirstSelectedOption().getText());

        driver.findElement(By.xpath("//*[@id='transferForm']/div[2]/input")).click();
        Thread.sleep(2000);
        System.out.println("Transfer Completed");


        String msg = driver.findElement(By.xpath("//*[@id='showResult']/h1")).getText();
        System.out.println("Result: " + msg);

        driver.findElement(By.linkText("Log Out")).click();
        Thread.sleep(1000);
       

        driver.quit();
    }
}
