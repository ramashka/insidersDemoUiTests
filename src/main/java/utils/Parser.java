package utils;

import data.ElectronicItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static Pattern p = Pattern.compile("ITEM\\s+\\d+");

    public static List<ElectronicItem> parse(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<ElectronicItem> items = new ArrayList<>();
        String s;
        ElectronicItem item = null;
        while ((s = br.readLine()) != null) {
            if (s != null && s.length() > 0) {
                Matcher m = p.matcher(s);
                if (m.find()) {
                    Integer id = Integer.parseInt(s.replaceAll("\\D+", ""));
                    item = new ElectronicItem(id);
                    items.add(item);
                } else if (s.startsWith("Title")) {
                    item.setTitle(s.split("=")[1]);
                } else if (s.startsWith("Binding")) {
                    item.setBinding(s.split("=")[1]);
                } else if (s.startsWith("Brand=")) {
                    item.setBrand(s.split("=")[1]);
                } else if (s.startsWith("Color")) {
                    item.setColor(s.split("=")[1]);
                } else if (s.startsWith("Feature=")) {
                    item.addFeature(s.split("=")[1]);
                }
            }
        }
//        items.forEach(i -> System.out.println(i));
        return items;
    }

}
