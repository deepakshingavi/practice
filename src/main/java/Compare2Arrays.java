import java.util.Arrays;

public class Compare2Arrays {

    public static void main(String[] args) {

    }

    public static boolean isSame(int[] ArrayX,int [] ArrayY){

        if(ArrayX.length!=ArrayY.length)// to check that they have the same size
            return false;

        // Sort both arrays
        Arrays.sort(ArrayX);
        Arrays.sort(ArrayY);
        for (int i=0;i<ArrayX.length;i++){
            if (ArrayX[i]!=ArrayY[i]){ // Compare elements
                return false;  //
            }
        }
        return true;
    }
}
