import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapConverter {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> AMap = new HashMap<>();
        AMap.put("key1","value1");
        AMap.put("key2","value2");
        Map<String,Object> BMap = new HashMap<>();
        BMap.put("key1","value1");
        BMap.put("key2","value2");
        map.put("A",AMap);
        map.put("B",BMap);

        //Java 7
        List<Map<String, Object>> mapList7 = new ArrayList<>();
        for (Object obj :map.values()) {
            mapList7.add((Map<String, Object>) obj);
        }
        System.out.println(mapList7);

        // java 8
        final List<Map<String, Object>> mapList = map.values().stream().map(obj -> (Map<String, Object>) obj).collect(Collectors.toList());
        System.out.println(mapList);
    }

}
