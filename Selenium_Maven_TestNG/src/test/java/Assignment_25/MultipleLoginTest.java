package Assignment_25;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password)
            throws InterruptedException {

        // Enter Username
        driver.findElement(By.id("username"))
              .sendKeys(username);

        // Enter Password
        driver.findElement(By.id("password"))
              .sendKeys(password);

        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']"))
              .click();

        Thread.sleep(2000);

        System.out.println("Login Tested with: "
                + username + " / " + password);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {

        return new Object[][] {

                {"admin", "admin123"},
                {"user", "user123"},
                {"test", "test123"}

        };
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}