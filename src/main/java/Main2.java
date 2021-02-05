import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main2{


    static Iterator func(ArrayList mylist){
        Iterator it=mylist.iterator(); // Get the iterator reference
        while(it.hasNext()){           // Check if there are more element to the list
            Object element = it.next(); // fetch the next element from the list
            if (element.equals("###")) // compare the list element with break point element
                break;                 // come out of the loop with iterator pointing to the break point
        }
        return it;                     // return the iterator as is

    }

    @SuppressWarnings({ "unchecked" })
    public static void main(String []args){
        ArrayList mylist = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // CLI will read user first input int value as save it as n
        int m = sc.nextInt(); // CLI will read user first input int value as save it as m
        for(int i = 0;i<n;i++){  // CLI will expect n integers in CLI
            mylist.add(sc.nextInt());
        }


        mylist.add("###");
        for(int i=0;i<m;i++){ // CLI will expect m integers in CLI
            mylist.add(sc.next());
        }

        Iterator it=func(mylist);
        while(it.hasNext()){    // check if there is element after break point
            Object element = it.next(); // get the element
            System.out.println((String)element); // print it
        }
    }
}