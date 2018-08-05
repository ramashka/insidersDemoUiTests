package helpUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckBindings {
    private static String FILE="amazondata_Electronics_14200.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(FILE));
        Map<String,Long> params=new LinkedHashMap<>();
        String s=null;
        while ((s=br.readLine())!=null){
            if (s.startsWith("Binding")){
                String param=s.split("=")[1];
                Long count=params.get(param);
                count=count==null? 0L:count+1;
                params.put(param,count);
            }
        }
        params.entrySet().forEach(e->System.out.println(e.getKey() +" - "+ e.getValue()));
    }
}
