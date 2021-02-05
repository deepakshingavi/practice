public class RobotCoinCollector {

    public static int collectCoins(int[][] board) {

        int[][] F = new int[board.length][board[0].length];

        int previousStage;
        for (int j = 0; j < board.length; ) {
            for (int i = 0; i < board[j].length; ) {
//                System.out.print("("+i+","+j+") = "+board[j][i]+" ");
                System.out.print("("+i+","+j+") = "+board[j][i]+" ");
                boolean canTraverseCol = (j+1) < board[j].length;
                boolean canTraverseRow = (i+1) < board.length;
                if( canTraverseCol && canTraverseRow && board[j+1][i] > board[j][i+1]) {
                    j++;
                    break;
                }
                i++;
            }
//            j++;
            System.out.println();
        }
        return F[board.length - 1][board[0].length - 1];

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] board = {
                {0, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0}
        };
        //4,5 3,5 2,5 2,4 2,3 1,3 1,2 1,1 1,0 0,0
        System.out.println("Total=" + collectCoins(board));
    }

}
