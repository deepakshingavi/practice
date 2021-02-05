import java.util.Scanner;

public class HW5 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = kb.nextInt();
        System.out.println("Your number  is: "+num);
        getCount(num);
    }

    public static int getCount(int num) {
        int count=0;
        for(int i = 10, innerNum; ; i=i*10) {
            innerNum = (num%i)/(i/10);
            if(innerNum==0){
                break;
            }
            if(  3 <= innerNum && innerNum <=6 ) {
                count++;
            }
            System.out.println(innerNum);
        }
        return count;
    }
}
