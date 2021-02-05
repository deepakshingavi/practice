import java.util.*;
import java.lang.*;
public class TestSwitch {




        public static void main (String[] args) {

            System.out.println("Enter Any one number from following list to carry out Equation  ");
            System.out.println("1.Add ");
            System.out.println("2.Subtract ");
            System.out.println("3.Divide ");
            System.out.println("4.Multiply ");
            Scanner in=new Scanner(System.in);
            int read=in.nextInt();

            System.out.println("Enter 2 number for Equation ");
            double a=in.nextDouble();
            double b=in.nextDouble();
            double r=0;
            switch (read) {
                case 1 : r = a + b;
                case 2 : r = a - b;
                case 3 : r = a / b;
                case 4 : r = a * b;
                default : {
                    System.out.println("Error! Select from 1 to 4 ");
                }
            }
            System.out.println("Result of Equation is:  "+r);
        }

}
