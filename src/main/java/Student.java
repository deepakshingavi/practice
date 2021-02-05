import java.util.ArrayList;

public class Student {

    public static void main(String[] args) {
        displayData();
    }

    public static void displayData() {
        int start = 'A';
        int finish = 'Z';
        for (int i = start ; i < finish; i++){
            for (int j = start ; j <= i; j++) {
                System.out.print((char)j);
            }
            System.out.println();
        }
    }
}
