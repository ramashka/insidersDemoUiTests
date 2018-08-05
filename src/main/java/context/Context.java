package context;

import config.Config;

import org.openqa.selenium.WebDriver;

public class Context {
    public static Config config = Config.LOCAL;
    private static WebDriver driver;

    public static String getFrontEndUrl() {
        return config.getURL_FE();
    }

    public static WebDriver buildDriver() {
        if (driver != null) {
            driver = DriverBuilder.build();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
