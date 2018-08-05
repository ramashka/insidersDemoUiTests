package helpUtils;

import data.ElectronicItem;
import utils.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataCategoryHitter {
    private static String FILE = "amazondata_Electronics_14200.txt";
    private static String uniqueTitle="RCA Digital-to-Analog Converter Box";
    private static String uniqueBinding="Luggage";

    public static void main(String[] args) throws IOException {
        List<ElectronicItem> eItems=Parser.parse(FILE);
        Map<String,Integer> mapa=findFeature(eItems);
        List<String> sort=sort(mapa);
        for (String s: sort) {
            check(eItems, s);
        }
    }

    private static List<String> sort(Map<String,Integer> mapa){
        List<String> list=new ArrayList<>();
        for (Map.Entry<String,Integer> e : mapa.entrySet()){
            if (e.getValue().equals(1)){
                list.add(e.getKey());
                System.out.println(e.getKey());

            }
        }
        return list;
    }

    private static Map<String,Integer> find(List<ElectronicItem> eItems) throws IOException {
        Map<String, Integer> mapa=new LinkedHashMap<>();
        for (ElectronicItem ei: eItems){
            String s=ei.getColor();
            Integer count=mapa.get(s);
            count=count==null?1:count+1;
            mapa.put(s,count);
        }
        return mapa;
    }

    private static Map<String,Integer> findFeature(List<ElectronicItem> eItems) throws IOException {
        Map<String, Integer> mapa=new LinkedHashMap<>();
        for (ElectronicItem ei: eItems){
            List<String> list=ei.getFeatures();
            for (String s : list) {
                Integer count = mapa.get(s);
                count = count == null ? 1 : count + 1;
                mapa.put(s, count);
            }
        }
        return mapa;
    }

    private static void check(List<ElectronicItem> eItems,  String s){
        for (ElectronicItem ei : eItems) {
            if (ei.checkAllFieldsForText(s)) {
                System.out.println(ei);
            }
        }

    }

}
