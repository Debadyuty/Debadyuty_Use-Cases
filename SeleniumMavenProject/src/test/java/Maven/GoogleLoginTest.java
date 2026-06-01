package Maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLoginTest
{
    public static void main(String[] args) throws InterruptedException
    {

        WebDriver driver = new ChromeDriver();

        driver.get("https://accounts.google.com/");

        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Enter Email
        driver.findElement(By.id("identifierId")).sendKeys("debadyutygayen@gmail.com");
        Thread.sleep(2000);

        // Click Next
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(3000);

        // Enter Password
        driver.findElement(By.name("Passwd")).sendKeys("yourpassword");
        Thread.sleep(2000);

        // Click Next
        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(5000);

        System.out.println(driver.getTitle());

        driver.quit();
    }
}