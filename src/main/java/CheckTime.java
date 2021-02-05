import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class CheckTime {
    public static void main(String[] args) {
        //Start your scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("What time is it?");
        DateFormat df = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        //Read the entire line as a String
        String time = scan.nextLine();

        //Format your datatetim in HH:mm format and compare the strings
        if (time.equals(df.format(date))) {                       // I know it's not correct but you get what I want
            System.out.println("That's right");
        } else {
            System.out.println("That's wrong");
        }
        //Never forget to close your scanner
        scan.close();
    }
}
