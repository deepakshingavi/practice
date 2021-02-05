import java.util.Collection;

public class MyClass {
     <T> void add(Collection<T> value) {
        for (T v : value) {

            /*if(v instanceof Boolean) {
                add((Boolean) v);
            } else if (v instanceof Integer) {
                add((Integer) v);
            } else {
                throw new IllegalStateException("Unexpected value: " + v.getClass());
            }*/

            //
//            add(v);  // <-- ERROR here
        }
    }

    void add(Boolean val) {
        // ...
    }
}
