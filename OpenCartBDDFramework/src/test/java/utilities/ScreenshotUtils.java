package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.BaseClass;

public class ScreenshotUtils extends BaseClass {

    public static void capture(String name)
            throws Exception {

        File src =
                ((TakesScreenshot)driver)
                .getScreenshotAs(OutputType.FILE);

        File dest =
                new File("screenshots/" + name + ".png");

        FileHandler.copy(src, dest);
    }
}