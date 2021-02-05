import java.text.DecimalFormat;

public class DecimalFormatting {
    public static void main(String[] args) {
        double answer = 5.0;
        double answer1 = 5.55555555;
        DecimalFormat df = new DecimalFormat("###.####");
        System.out.println(df.format(answer));
        System.out.println(df.format(answer1));
    }
}
