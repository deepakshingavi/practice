import java.util.Scanner;

public class Game {

    public static void main(String[] args)  {
        String emailRegex = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "[A-Za-z0-9-]+(\\.com|abc\\.co|abc\\.nz|abc\\.org)$";
        boolean b = false;
        do {
        System.out.println("Enter a valid email address: ");
        Scanner scan = new Scanner(System.in);
        String emailAddress = scan.nextLine().trim();
        String testString = emailAddress;
        b = testString.matches(emailRegex);

        if (b)
        {
            System.out.println("The email address \"" + emailAddress + "\" is valid.");
        }
        else
        {
            System.out.println("The email address \"" + emailAddress + "\" IS NOT valid.");
        }
    } while (!b);

    }

    /*public static void printMap()  {
        for (String treeKey : nMap.keySet()) {
            System.out.println(nMap);
        }
    }*/
}