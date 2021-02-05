


import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

public class Countries {
    static List country = Arrays.asList("Singapore", "America", "France", "Japan", "China", "UK", "Indonesia", "India");

    public static void main(String[] args) {
            try {
//                countries.callMethod();
            } catch (RuntimeException rex) {
                rex.printStackTrace();
            }
    }

    public void callMethod() {
        if (null != country && country.size() > 5) {
            throw new RuntimeException("Maximum countries allowed are 5");
        }
    }

}
