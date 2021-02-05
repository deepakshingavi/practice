public class Print2DArray {

    public static void main(String[] args) {
        int seatNo = 1;
        int row = 8;    // set row count
        int column = 7; // set column count

        int[][] print2DArray = new int[row][column]; // init your 2d seat matrix

        for (int i = 0; i < print2DArray.length; i++) {
            for (int j = 0; j < print2DArray[i].length/2; j++) {
                System.out.print(seatNo++ + " ");
//                System.out.print(print2DArray[i][j]++ + " ");  // You can use this line to print the value on the current position in the array position
            }
            System.out.print("x ");
            for (int j = 0; j < print2DArray[i].length/2; j++) {
                System.out.print(seatNo++ + " ");
//                System.out.print(print2DArray[i][j]++ + " ");  // You can use this line to print the value on the current position in the array position
            }
            System.out.println();
        }
    }
}
