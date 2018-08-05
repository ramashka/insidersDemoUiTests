package fe.search;

import context.Context;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class Search {
    private static By SEARCH_ID = By.id("formBasicText");
    private static By LIST_ID = By.id("render-list");
    private static By CATEGORY_CLASS = By.xpath("./a[@class='list-group-item list-group-item-info']");
    private static By ITEM_CLASS = By.xpath("./a[@class='list-group-item']");
    private String url;
    private WebDriver driver;

    public Search() {
        this.url = Context.getFrontEndUrl();
        driver = Context.buildDriver();
    }

    public Search(String url, WebDriver driver) {
        this.url = url;
        this.driver = driver;
    }

    public void gotoPage() {
        driver.get(url);
        waitForLoad();
    }

    public WebElement getSearchBar() {
        return driver.findElement(SEARCH_ID);
    }

    public void search(String search) {
        WebElement sb = getSearchBar();
        sb.sendKeys(search);
        sb.sendKeys(Keys.RETURN);
    }

    public WebElement getList() {
        return driver.findElement(LIST_ID);
    }

    public List<String> getCategories() {
        List<WebElement> elements = getList().findElements(CATEGORY_CLASS);
        List<String> categories = elements.stream().map(e -> e.getText()).collect(Collectors.toList());
        return categories;
    }

    public void waitForLoad() {
        waitFor(SEARCH_ID);
    }

    public List<String> getItems() {
        List<WebElement> elements = getList().findElements(ITEM_CLASS);
        List<String> categories = elements.stream().map(e -> e.getText()).collect(Collectors.toList());
        return categories;
    }

    public void waitForList() {
        waitFor(LIST_ID);
    }

    private void waitFor(By by) {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
