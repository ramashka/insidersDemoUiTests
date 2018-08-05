package helpUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CheckFile {
    private static String FILE="amazondata_Electronics_14200.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(FILE));
        Map<String,Long> params=new LinkedHashMap<>();
        String s=null;
        while ((s=br.readLine())!=null){
            if (s.contains("=")){
                String param=s.split("=")[0];
                Long count=params.get(param);
                count=count==null? 0L:count+1;
                params.put(param,count);
            }
        }
        params.entrySet().stream().forEach(e->System.out.println(e.getKey() +" - "+ e.getValue()));
    }
}
