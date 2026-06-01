package SDET_DAY25;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDT {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{	
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Debadyuty\\IMPORTANT FILES\\WIPRO TECHNICAL\\Data Driven Book.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("Sheet1");

		int rows = sh.getLastRowNum();

		for(int i = 1; i <= rows; i++)
		{
			String Username = sh.getRow(i).getCell(0).getStringCellValue();
			String Password = sh.getRow(i).getCell(1).getStringCellValue();

			WebDriver driver = new ChromeDriver();

			driver.get("https://www.saucedemo.com");

			driver.findElement(By.id("user-name")).sendKeys(Username);
			driver.findElement(By.id("password")).sendKeys(Password);

			driver.findElement(By.id("login-button")).click();

			System.out.println("Done");

			driver.quit();
		}

		wb.close();
	}
}