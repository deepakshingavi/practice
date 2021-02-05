import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        String answer;
        do {

            Scanner ab = new Scanner(System.in);
            System.out.println("Input what operation do you want to do!");
            System.out.println("For gather: \"+\"");
            System.out.println("For reduction: \"-\"");
            System.out.println("For division: \"/\"");
            System.out.println("For multiplication: \"*\"");
            System.out.print(":");

            String operation = ab.nextLine();


            try {
                System.out.print("Input first number: ");
                int nr1 = ab.nextInt();
                System.out.print("Input second number: ");
                int nr2 = ab.nextInt();

                int gather, reduction, division, multiplication;
                gather = nr1 + nr2;
                reduction = nr1 - nr2;
                division = nr1 / nr2;
                multiplication = nr1 * nr2;
                switch (operation) {
                    case "+":
                        System.out.println("The result is: " + gather);
                        break;
                    case "-":
                        System.out.println("The result is: " + reduction);
                        break;
                    case "/":
                        System.out.println("The result is: " + division);
                        break;
                    case "*":
                        System.out.println("The result is: " + multiplication);
                        break;
                    default:
                        System.out.println(" !!!! You haven't chosen an operation...  \n **** Input smth like: \n+ -> gather\n- -> reduction\n/ -> division\n* -> multiplication");
                }
            } catch (InputMismatchException e) {
                System.out.println(" ------------------------------ You have to choose an operation ------------------------------");
            }


            System.out.println("Do you keep going? Yes/ No");
            Scanner tx = new Scanner(System.in);
            answer = tx.nextLine();
        }

        while (answer.equalsIgnoreCase("Yes"));

    }
}
