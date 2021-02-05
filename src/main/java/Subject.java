import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class Subject {

    public static void main(String[] args) {
//        dropping(1);
        System.out.println(digitSumUsingMathTrick("10",8));
    }

    public static int dropping(int quantity) {
        LinkedList<String> course = new LinkedList<String>();
        Scanner input = new Scanner(System.in);
        System.out.print("How many courses do you want to drop: ");
        int num = input.nextInt();   // accepting the total no. of subject to delete from user
        quantity = num;
        for (int i = 0; i < num; i++) {
            System.out.print("Delete Course: ");
            String element = input.next(); // accept the subject name from user
            course.remove(element);    // remove from the subject from the list
        }
        System.out.println();
        System.out.println("Course deleted successfully\n\n");
        for (int i = 0; i < course.size(); i++) {
            System.out.println(course.get(i));
        }
        return quantity;  // retrurn the no. of subject deletes attempted by user
    }

    static int digitSumUsingMathTrick(String n, int k) { // n1 = 10,k=8
        BigInteger n1 = new BigInteger(n);         // Initialise n1 , n1 = 4
        n1 = n1.multiply(new BigInteger(k + ""));  // multiple n1 with k and adding it to n1 i.e. n1 = 10 * 8 = 80
        n1 = n1.remainder(new BigInteger("9"));    // n1 = n1 % 9  = 80 % 9 = 8
        return n1.intValue() == 0 ? 9 : n1.intValue(); // if (n1 == 8) then return 9 else return 8
    }
}
