import org.apache.http.HttpRequest;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.AsyncContext;

public class BigNumbers {
    private String props;
    public static void main(String[] args) {
        /*final BigNumbers bigNumbers = new BigNumbers();
        bigNumbers.numArray = new int[]{9999};

        final BigNumbers bigNumbers1 = new BigNumbers();
        bigNumbers1.numArray = new int[]{999};
        transfer(bigNumbers, bigNumbers1);*/

         Calendar cal = Calendar.getInstance();
         cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY,7);

    }

    /*public void setProps(AppProperties props) {
        this.props = props;
    }

    public AppProperties getProps() {
        return props;
    }*/

    public int[] numArray;

    public static void transfer(BigNumbers num1, BigNumbers num2) {
        int len1 = num1.numArray.length;
        int len2 = num2.numArray.length;
        int[] tmp; //put the shorter num in the tmp array
        if (len1 < len2) {
            tmp = num2.numArray;
            num2.numArray = Arrays.copyOf(tmp, len1);
        } else
            tmp = num1.numArray;
        num1.numArray = Arrays.copyOf(tmp, len2);

    }
}