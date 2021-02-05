public class MethodsRecursiveRange {

    public static void main(String[] args) {
        Range(2,10); // Start
    }

    public static int Range (int curr, int max) {
        System.out.println(curr);   // Print the current value
        if(max<=curr) {             // Check if the Current value is greater or equal to Maximum limit
            return 0;               // Stop the recursion with 0 as return value
        }
        return Range(++curr,max);   // Continue recursion with keeping max same, increment current value and invoke Range

    }
}