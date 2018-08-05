package insider.test.fe;

import fe.search.Search;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

public class OneSymbolTest extends AbstractUiTest {

    @Test(expectedExceptions = TimeoutException.class)
    public void oneSymbolTest() {
        Search search = buildSearchPage();
        search.search("s");
        search.waitForList();
    }
}
