import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class SeriesHW {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Till what number you want to calculate this series?");
        int n = input.nextInt();
        BigDecimal resultone = BigDecimal.ZERO;
        for (int i = 1; i <= n; i = i + 2) {
            resultone = resultone.add(BigDecimal.ONE.divide(BigDecimal.valueOf(i),2, RoundingMode.CEILING));
        }
        BigDecimal resulttwo = BigDecimal.ZERO;
        for (int j = 2; j <= n; j = j + 2) {

            resulttwo = resulttwo.add(BigDecimal.ONE.divide(BigDecimal.valueOf(j),2, RoundingMode.CEILING));

        }
        BigDecimal finalresult = resultone.subtract(resulttwo) ;
        System.out.println("Answer is : " + finalresult);
    }

}
