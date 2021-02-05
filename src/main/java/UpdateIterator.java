import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UpdateIterator {
    public static void main(String[] args) {
        Map<Integer,Integer> m1 = new ConcurrentHashMap<>();
        m1.put(3, 1);
        m1.put(4, 1);
        m1.put(5, 2);
        m1.put(6, 3);
        Iterator<Map.Entry<Integer, Integer>> i1 = m1.entrySet().iterator();
        System.out.println(m1.remove(4));        // remove entry from map
        while (i1.hasNext())
            System.out.println("value :: "+i1.next()); //still shows entry 4=1
    }
}
