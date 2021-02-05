import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wektory
{
    List<Integer> wektor = new ArrayList<Integer>();
    public Wektory(){}
    public void readMy()
    {
        Scanner C=new Scanner(System.in);
        while(C.hasNextInt()){
            int val = C.nextInt();
            if(val==-1){
                break;
            }
            wektor.add(C.nextInt());
        }
    }
}