public class ScanRaggedArray {

    public static void main(String args[]) {

        int maxNumberOfColumns=8;

        Integer[][] j = { { 2, 4, 8, 5, 1, 3, 7, 2 }, { 6, 7, 4, 8, 2 }, { 2, 3, 5, 9, 7, 1 } };

        for (int row = 0; row < j.length; row++) {
            for (int col = 0; col < j[row].length; col++) {

                System.out.print(j[row][col] + "  ");

            }
            System.out.println();

        }

        System.out.println();
        System.out.println("------------");
        System.out.println();

        for (int row = 0; row < j.length; row++) {

            System.out.println("row "+row+" has "+j[row].length+" elements");
        }

        System.out.println();


        for(int col=0; col<maxNumberOfColumns; col++) {

            //code I don't know
        }
    }
}
