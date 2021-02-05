import java.util.Arrays;
import java.util.Random;

public class RecurseFunc {

    public static void main(String[] args) {
//        int[] arr = new int[]{3,2,2,1};
        int[] arr = new int[]{3,2,4,1,1};
//        System.out.println(problem1(arr,0,3));
//        System.out.println(problemRec(arr, 4,-1,0));
        System.out.println(problemRecWrapper(new int[]{-1,2,4,1,0}, 4,  0));
    }

    static boolean  problemRecWrapper(int[] arr, int arrLastIndex, int currentIndex) {
        return problemRec(new int[]{-1,2,4,1,0}, 4, -1, 0);
    }

    /**
     *
     * @param arr      Complete array
     * @param arrLastIndex - Starting index point
     * @param lastIndex - Last element index
     * @param currentIndex - Current arr index
     * @return
     */
    static boolean  problemRec(int[] arr, int arrLastIndex, int lastIndex, int currentIndex) {
        if(currentIndex > arrLastIndex) {
            return false;
        }
        if(lastIndex > 0 && arr[lastIndex] == arr[currentIndex]) {
            return true;
        }
        currentIndex++;
        return problemRec(arr, arrLastIndex,lastIndex,currentIndex);

    }
}
