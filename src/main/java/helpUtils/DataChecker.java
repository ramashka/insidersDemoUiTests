package helpUtils;

import data.ElectronicItem;
import utils.Parser;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataChecker {
    private static String FILE = "amazondata_Electronics_14200.txt";

    public static void main(String[] args) throws IOException {
        List<ElectronicItem> eItems = Parser.parse(FILE);
        Map<String, Integer> mapa = findIphons(eItems, "iphone");
        mapa.entrySet().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }

    private static Map<String, Integer> findIphons(List<ElectronicItem> eItems, String s) {
        String lowerCase = s.toLowerCase();
        Map<String, Integer> mapa = new LinkedHashMap<>();
        for (ElectronicItem ei : eItems) {
            boolean hit = false;
            if (ei.getTitle() != null) {
                hit = ei.getTitle().toLowerCase().contains(lowerCase);
            }
            if (!hit && ei.getBinding() != null) {
                ei.getBinding().toLowerCase().contains(lowerCase);
            }
            if (!hit && ei.getBrand() != null) {
                ei.getBrand().toLowerCase().contains(lowerCase);
            }
            if (!hit && ei.getColor() != null) {
                ei.getColor().toLowerCase().contains(lowerCase);
            }
            if (!hit && ei.getFeatures() != null && ei.getFeatures().size() > 0) {
                for (String feature : ei.getFeatures()) {
                    if (!hit && feature != null && feature.toLowerCase().contains(lowerCase)) {
                        hit = true;
                        break;
                    }

                }
            }
            if (hit) {
                Integer count = mapa.get(ei.getBinding());
                count = count == null ? 1 : count + 1;
                mapa.put(ei.getBinding(), count);
            }
        }
        return mapa;
    }

}
