public class DoWhile {

    public static double avgArry(double[] a) {
        double sum = 0;
        double average = 0;
        int i = 0;

        do  {
            sum += a[i];
            average = sum / a.length;
            ++i;
        } while(i < a.length);


        return average;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double j;
        double[] array = {1.5, 20.3, 4.5, 5.5, 10.3, 450, 20.4, -22.3};

        j = avgArry(array);

        System.out.format("The average is: %.3f", j);


    }


}
