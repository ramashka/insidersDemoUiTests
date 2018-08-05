package context;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBuilder {
    private static String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public static WebDriver build() {
        String driverPath = new File("chromedriver_v_2_40").getAbsolutePath();
        new File(driverPath).setExecutable(true);
        System.setProperty(CHROME_DRIVER_PROPERTY, driverPath);
        return new ChromeDriver();
    }

}
