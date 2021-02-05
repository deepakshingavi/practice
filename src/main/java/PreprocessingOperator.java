import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class PreprocessingOperator {

    public static void main(String[] args) {
        /*final List<Integer> integers = Arrays.asList(1, 2, 3);
        for( Integer j : integers  ) {
            int i = 1;  // for every loop you are resetting the i's value to 1
            i = i++;   // it is expanded to i = i; i=i+1;
            System.out.println("---"+i);
            System.out.println(i + j + " and ");

        }*/

        BigDecimal bigD = new BigDecimal("0.0000000000").add(new BigDecimal("0.0000000001"));
        System.out.println(bigD.toPlainString());
    }
}
