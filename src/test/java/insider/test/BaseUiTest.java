package insider.test;

import context.DriverBuilder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class BaseUiTest {
    WebDriver driver;

    @BeforeClass
    public void prepareWebDriver() {
        driver = DriverBuilder.build();
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void baseUiTest() throws InterruptedException {
        driver.get("https://google.com");
        WebElement searchBar = driver.findElement(By.id("lst-ib"));
        searchBar.sendKeys("siski");
        driver.findElement(By.name("btnK")).click();
        TimeUnit.SECONDS.sleep(10L);
    }

}
