public class Trinomial {

    public static void main(String[] args) {
        trinomial(3,2);
    }

    public static long trinomial(int n, int k) {
        long[][] DP = new long[n + 1][k + 1];
        DP[0][0] = 1;
        if (k < 0) k = -k;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (j == 1 || j == i) DP[i][j] = 1;
                else {
                    DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j] + DP[i - 1][j + 1];
                }
            }
        }
        return DP[n][k];
    }
}
