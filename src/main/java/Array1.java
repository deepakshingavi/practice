import java.util.Scanner;

public class Array1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];

        for (int g = 0; g < n1; g++) {
            arr1[g] = scanner.nextInt();
        }

        int n2 = scanner.nextInt();
        int[] arr2 = new int[n1];

        for (int h = 0; h < n2; h++) {
            arr2[h] = scanner.nextInt();
        }
        int[] sum = new int[n1 > n2 ? n1 : n2];

        int i = n1 - 1;
        int j = n2 - 1;
        int k = sum.length - 1;
        int c = 0;
        while ((i >= 0) || (j >= 0)) {

            int d = c;

            if (i != 0) {
                d += arr1[i];
            }
            if (j != 0) {
                d += arr2[j];
            }

            c = d / 10;
            d = d % 10;
            sum[k] = d;
            i--;
            j--;
            k--;

        }
        if (c > 0) {
            System.out.println(c);
        }
        for (int val : sum) {
            System.out.println(val);
        }
    }

}
