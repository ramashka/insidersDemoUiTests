package insider.test.fe;

import context.Context;
import context.DriverBuilder;
import fe.search.Search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
public abstract class AbstractUiTest {
    protected static String FE_URL = Context.getFrontEndUrl();
    protected WebDriver driver;

    protected Search buildSearchPage() {
        Search search = new Search(FE_URL, driver);
        search.gotoPage();
        return search;
    }

    protected void sleep(long msec) {
        try {
            TimeUnit.MILLISECONDS.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void prepareWebDriver() {
        driver = DriverBuilder.build();
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
