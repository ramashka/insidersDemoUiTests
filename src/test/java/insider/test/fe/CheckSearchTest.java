package insider.test.fe;

import data.ElectronicItem;
import fe.search.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

import static data.ElectronicItem.clearCategories;

public class CheckSearchTest extends AbstractUiTest {
    private ElectronicItem UNIQUE_TITLE = new ElectronicItem(11, "RCA Digital-to-Analog Converter Box", "Electronics", "RCA", null, null);
    private ElectronicItem UNIQUE_BINDING = new ElectronicItem(1539, "Gunnar Optiks INT-00101 Intercept Full Rim Advanced Video Gaming Glasses with Amber Lens Tint, Onyx Frame Finish", "Game Cartridge", "Gunnar Optiks", "Onyx", null);
    private ElectronicItem UNIQUE_BRAND = new ElectronicItem(13, "Digital Stream Analog Pass-through DTV Converter Box", "Electronics", "DTX9950", "Black", null);
    private ElectronicItem UNIQUE_COLOR = new ElectronicItem(68, "Supersonic iKonvert DTV Digital to Analog Converter Box with HDMI 1080P Out and USB Media Player", null, "Supersonic", "ikonvert", null);
    private ElectronicItem UNIQUE_FEATURES = new ElectronicItem(1539, "Mediasonic HW180STB HomeWorx HDTV Digital Converter Box with Media Player Function, Dolby Digital and HDMI Out", "Electronics", "Mediasonic", null, Arrays.asList("USB Multimedia Player (Support USB Flash Drive up to 64GB)"));
    private ElectronicItem TYPO = new ElectronicItem(68, "Supersonic iKonvert DTV Digital to Analog Converter Box with HDMI 1080P Out and USB Media Player", null, "Supersonic", "ikovert", null);

//    ubnique title
//    Item{id=11, title='RCA Digital-to-Analog Converter Box', binding='Electronics', brand='RCA', color='null'}
//    unique binding
//    Item{id=1539, title='Gunnar Optiks INT-00101 Intercept Full Rim Advanced Video Gaming Glasses with Amber Lens Tint, Onyx Frame Finish', binding='Game Cartridge', brand='Gunnar Optiks', color='Onyx'}
//    unique Brand
//    Item{id=13, title='Digital Stream Analog Pass-through DTV Converter Box', binding='Electronics', brand='DTX9950', color='Black'}
//    unique Color
//    Item{id=68, title='Supersonic iKonvert DTV Digital to Analog Converter Box with HDMI 1080P Out and USB Media Player', binding='null', brand='Supersonic', color='ikonvert'}
//    unique Feature
//    Item{id=1, title='Mediasonic HW180STB HomeWorx HDTV Digital Converter Box with Media Player Function, Dolby Digital and HDMI Out', binding='Electronics', brand='Mediasonic', color='null'}

    @Test
    public void uniqueTitleTest() {
        ElectronicItem item = UNIQUE_TITLE;
        Search search = buildSearchPage();
        search.search(item.getTitle());
        sleep(2_000L);
        List<String> categories = search.getCategories();
        categories = clearCategories(categories);
        Assert.assertTrue(categories.size() > 0, "Count of found categories should be >0");
        Assert.assertTrue(categories.contains(item.getBinding()), "Found categories should contains category: " + item.getBinding());
        List<String> items = search.getItems();
        Assert.assertNotNull(items);
        Assert.assertTrue(items.size() > 0, "Count of found items should be >0");
        Assert.assertTrue(items.contains(item.getTitle()), "Found items should contains " + item.getTitle());
    }

    @Test
    public void uniqueBindingTest() {
        ElectronicItem item = UNIQUE_BINDING;
        Search search = buildSearchPage();
        search.search(item.getBinding());
        sleep(2_000L);
        List<String> categories = search.getCategories();
        categories = clearCategories(categories);
        Assert.assertTrue(categories.size() > 0, "Count of found categories should be >0");
        Assert.assertTrue(categories.contains(item.getBinding()), "Found categories should contains category: " + item.getBinding());
        List<String> items = search.getItems();
        Assert.assertNotNull(items);
        Assert.assertTrue(items.size() > 0, "Count of found items should be >0");
        Assert.assertTrue(items.contains(item.getTitle()), "Found items should contains " + item.getTitle());
    }

    @Test
    public void uniqueBrandTest() {
        ElectronicItem item = UNIQUE_BRAND;
        Search search = buildSearchPage();
        search.search(item.getBrand());
        sleep(2_000L);
        List<String> categories = search.getCategories();
        categories = clearCategories(categories);
        Assert.assertTrue(categories.size() > 0, "Count of found categories should be >0");
        Assert.assertTrue(categories.contains(item.getBinding()), "Found categories should contains category: " + item.getBinding());
        List<String> items = search.getItems();
        Assert.assertNotNull(items);
        Assert.assertTrue(items.size() > 0, "Count of found items should be >0");
        Assert.assertTrue(items.contains(item.getTitle()), "Found items should contains " + item.getTitle());
    }

    @Test
    public void uniqueColorTest() {
        ElectronicItem item = UNIQUE_COLOR;
        Search search = buildSearchPage();
        search.search(item.getColor());
        sleep(2_000L);
        List<String> items = search.getItems();
        Assert.assertNotNull(items);
        Assert.assertTrue(items.size() > 0, "Count of found items should be >0");
        Assert.assertTrue(items.contains(item.getTitle()), "Found items should contains " + item.getTitle());
    }

    @Test
    public void uniqueFeatureTest() {
        ElectronicItem item = UNIQUE_FEATURES;
        Search search = buildSearchPage();
        search.search(item.getFeatures().get(0));
        search.waitForList();
        List<String> categories = search.getCategories();
        categories = clearCategories(categories);
        Assert.assertTrue(categories.size() > 0, "Count of found categories should be >0");
        Assert.assertTrue(categories.contains(item.getBinding()), "Found categories should contains category: " + item.getBinding());
        List<String> items = search.getItems();
        Assert.assertNotNull(items);
        Assert.assertTrue(items.size() > 0, "Count of found items should be >0");
        Assert.assertTrue(items.contains(item.getTitle()), "Found items should contains " + item.getTitle());
    }

    @Test
    public void checkTypoWordsTest() {
        ElectronicItem item = TYPO;
        Search search = buildSearchPage();
        search.search(item.getColor());
        search.waitForList();
        List<String> items = search.getItems();
        Assert.assertNotNull(items);
        Assert.assertTrue(items.size() > 0, "Count of found items should be >0");
        Assert.assertTrue(items.contains(item.getTitle()), "Found items should contains " + item.getTitle());
    }

}
