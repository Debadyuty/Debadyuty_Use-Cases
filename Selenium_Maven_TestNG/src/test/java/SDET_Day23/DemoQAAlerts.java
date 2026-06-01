package SDET_Day23;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQAAlerts {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/alerts");

        // 1st Alert Button
        driver.findElement(By.id("alertButton")).click();

        Alert alert1 = driver.switchTo().alert();

        System.out.println(alert1.getText());

        alert1.accept();

        Thread.sleep(2000);

        // 2nd Alert Button
        driver.findElement(By.id("timerAlertButton")).click();

        Thread.sleep(6000);

        Alert alert2 = driver.switchTo().alert();

        System.out.println(alert2.getText());

        alert2.accept();

        Thread.sleep(2000);

        // 3rd Alert Button
        driver.findElement(By.id("confirmButton")).click();

        Alert alert3 = driver.switchTo().alert();

        System.out.println(alert3.getText());

        alert3.accept();

        Thread.sleep(2000);

        // 4th Alert Button
        driver.findElement(By.id("promtButton")).click();

        Alert alert4 = driver.switchTo().alert();

        alert4.sendKeys("Debadyuty");

        Thread.sleep(2000);

        alert4.accept();

        Thread.sleep(3000);

        driver.quit();
    }
}