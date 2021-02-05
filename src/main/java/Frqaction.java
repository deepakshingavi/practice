import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Frqaction {

    private static final double PI = 3.14;
    public static double calculateVolume(double r, double h){
        double Volume =  1/3.0 * PI * (r * r) * h;
        return Volume;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Radius: ");
        double r0 = input.nextDouble();
        System.out.print("Height: ");
        double h0 = input.nextDouble();
        double Volume = calculateVolume(r0, h0);
        System.out.println("Volume = " +Volume);

        List<String> fields = new ArrayList<>();

    }
}
