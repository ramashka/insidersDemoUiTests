package insider.test.fe;

import fe.search.Search;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HitOrderTest extends AbstractUiTest {
    //  Search hits for iphone
    //  Wireless Phone Accessory - 845
    //Electronics - 315
    //  Office Product - 64
    //  Personal Computers - 49
    //  Watch - 26

    private static String BINDING_1 = "Wireless Phone Accessory (845)";
    private static String BINDING_2 = "Electronics (315)";
    private static String BINDING_3 = "Office Product (64)";
    private static String BINDING_4 = "Personal Computers (49)";
    private static String BINDING_5 = "Watch (26)";

    @Test
    public void hitOrderTest() {
        Search search = buildSearchPage();
        search.search("iphone");
        sleep(2_000L);
        List<String> categories = search.getCategories();
        Assert.assertNotNull(categories);
        Assert.assertTrue(categories.size() > 0, "Count of found categories should be >0");
        Iterator<String> iterator = categories.iterator();
        Assert.assertEquals(iterator.next(), BINDING_1);
        Assert.assertEquals(iterator.next(), BINDING_2);
        Assert.assertEquals(iterator.next(), BINDING_3);
        Assert.assertEquals(iterator.next(), BINDING_4);
        Assert.assertEquals(iterator.next(), BINDING_5);
    }
}
