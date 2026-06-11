package Pages;

import org.openqa.selenium.*;
public class LoginPage
{
WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;

}
By username=By.name("username");
By password=By.name("password");
By loginBtn=By.xpath("//button[@type='submit']");
public void login(String user,String pass)
{
driver.findElement(username).sendKeys(user);
driver.findElement(password).sendKeys(pass);
driver.findElement(loginBtn).click();
}
}
