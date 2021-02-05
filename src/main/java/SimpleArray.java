import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleArray {

    public static void main(String[] args) {
        String[] array = new String[]{"a","b","c","ab","cd","abc","abcde","fghij","klmno"};

        Map<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            List< String> temp = map.getOrDefault(array[i].length(),new ArrayList<>());
            temp.add(array[i]);
            map.put(array[i].length(),temp);
        }
        System.out.println(map);

    }
}
