import java.util.HashMap;
import java.util.Map;

public class SetFieldIterator {

    public static void main(String[] args) {
        /**
         *  builder
         *     .setField(131, "5EB26EAAC074000D0000")
         *     .symbol("DANBNK")
         *     .securityID("SE0011116474")
         *     .currency("SEK")
         *     .securityIDSource("4")
         *     .setField(54, "2")
         *     .expireTime(expireTime)
         *     .orderQty(b1)
         *     .setField(64, "20200508")
         *     .setField(1629, "10")
         *     .setField(1916, "0")
         *     .setField(60, "20200526-15:48:53.006")
         *     .setField(761, "1")
         */

        final StringBuilder errorBuilder = new StringBuilder();

//        QuoteRequestBuilder builder = app.builders().quoteRequest();

        Map<Integer,String> fieldMap = new HashMap<>();
        fieldMap.put(131,"5EB26EAAC074000D0000");
        fieldMap.put(54,"2");
        fieldMap.put(64,"20200508");
        fieldMap.put(1629,"10");

        fieldMap.forEach((k,v)->{
//            builder.setField(k,v)
        });

    }
}
