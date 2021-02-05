import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] partsOfNums = num.split("-");
        int num1 = Integer.parseInt(partsOfNums[0].trim());
        int num2 = Integer.parseInt(partsOfNums[1].trim());
        int result = num1 - num2;
        System.out.println(result);

    }
}
