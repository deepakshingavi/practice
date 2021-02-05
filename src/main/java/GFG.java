import java.util.*;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static Scanner sc=new Scanner(System.in);
    public static void main (String[] args) {
        //code
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
            display();
    }
    static void display(){
        int n=sc.nextInt();
        Set<Integer> ts=new TreeSet<Integer>(new myComparator());
        int a;
        for(int i=0;i<n;i++){
            a=sc.nextInt();
            ts.add(a);
        }
        Iterator itr=ts.iterator();
        int count=0;
        while(itr.hasNext()){
            if(count==0)
                continue;
            else{
                System.out.print(itr.next()+" ");
            }
        }
        System.out.print(-1);
        System.out.println();
    }
}
class myComparator implements Comparator<Integer>{
    public int compare(Integer obj1,Integer obj2){
        if(obj2>obj1)
            return 1;
        else if(obj2<obj1)
            return -1;
        else
            return 0;
    }
}
