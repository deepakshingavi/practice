import java.net.Socket;
import java.util.*;

public class ScanPrintNoReverse {

    /**
     * Name: Stupid Me
     * 	Project: Ch15 Collection - print each digit of a number
     * 	Date: Tue Apr 14 11:10:58 EDT 2020
     * 	The number is 1729
     * 	1, 7, 2, 9,
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException nex){
            System.out.println("Invalid no.");
        }
        System.out.println("Name: Stupid Me");
        System.out.println("Project: Ch15 Collection - ");
        StringBuilder outputStrBuf = new StringBuilder();
        for (char c :input.toCharArray()) {
            System.out.print(c + " ");
            outputStrBuf.append(c).append(" ,");
        }
        System.out.println();
        String output = outputStrBuf.toString().substring(0,outputStrBuf.length()-2);
        System.out.println("Date: "+new Date());
        System.out.println("The number is "+input);
        System.out.println(output);
        sc.close();

    }
}
