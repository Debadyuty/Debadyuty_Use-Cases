package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    By addCart =
            By.xpath("(//button[contains(@title,'Add to Cart')])[1]");

    public void addProduct() {

        driver.findElement(addCart).click();
    }
}