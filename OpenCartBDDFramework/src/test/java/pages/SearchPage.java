package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {

        this.driver = driver;
    }

    By search =
            By.name("search");

    By searchBtn =
            By.cssSelector("button.btn.btn-light");

    public void searchProduct(String product) {

        driver.findElement(search).sendKeys(product);

        driver.findElement(searchBtn).click();
    }
}
