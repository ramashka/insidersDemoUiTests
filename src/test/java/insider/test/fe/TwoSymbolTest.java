package insider.test.fe;

import fe.search.Search;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoSymbolTest extends AbstractUiTest {

    @Test
    public void twoSymbolTest() {
        Search search = buildSearchPage();
        search.search("ip");
        search.waitForList();
        List<String> categories = search.getCategories();
        Assert.assertNotNull(categories);
        Assert.assertTrue(categories.size() > 0, "Count of found categories should be >0");
        List<String> items = search.getItems();
        Assert.assertNotNull(items);
        Assert.assertTrue(items.size() > 0, "Count of found items should be >0");
    }
}
