package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static String getUsername() throws Exception {

        FileInputStream fis =
                new FileInputStream(
                        "src/test/resources/testdata/data.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheet("Sheet1");

        String username =
                sheet.getRow(1).getCell(0)
                .getStringCellValue();

        wb.close();

        return username;
    }

    public static String getPassword() throws Exception {

        FileInputStream fis =
                new FileInputStream(
                        "src/test/resources/testdata/data.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheet("Sheet1");

        String password =
                sheet.getRow(1).getCell(1)
                .getStringCellValue();

        wb.close();

        return password;
    }
}