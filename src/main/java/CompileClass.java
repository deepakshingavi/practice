import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompileClass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        int[][] arr = new int[count][3];

        for (int i = 0; i < count; i++) {
            String[] arrNums = scan.nextLine().split(" ");

            arr[i][0] = Integer.parseInt(arrNums[0]);
            arr[i][1] = Integer.parseInt(arrNums[1]);
            arr[i][2] = Integer.parseInt(arrNums[2]);
        }

        List<Job> jobs = Arrays.stream(arr)
                .map(arrElement -> new Job(arrElement[0],arrElement[1],arrElement[2]))
                .collect(Collectors.toList());
    }
}

class Job // Job Class
{
    public int taskID, deadline, profit;

    public Job(int taskID, int deadline, int profit) {
        this.taskID = taskID;
        this.deadline = deadline;
        this.profit = profit;
    }
}
