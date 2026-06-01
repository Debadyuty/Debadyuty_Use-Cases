package SDET_DAY25;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenDatabase {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/saucedemo",
                "root",
                "Deba_12345");

        Statement st = con.createStatement();

        ResultSet rs =
                st.executeQuery("SELECT * FROM login");

        while(rs.next()) {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            String username = rs.getString("Username");
            String password = rs.getString("Password");

            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);

            driver.findElement(By.id("user-name"))
                    .sendKeys(username);
            Thread.sleep(2000);

            driver.findElement(By.id("password"))
                    .sendKeys(password);
            Thread.sleep(2000);

            driver.findElement(By.id("login-button"))
                    .click();
            Thread.sleep(3000);

            System.out.println("Login tested with: " + username);

            // Close browser after every login
            driver.quit();
        }

        con.close();
    }
}