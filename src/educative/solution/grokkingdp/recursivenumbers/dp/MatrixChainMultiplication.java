package educative.solution.grokkingdp.recursivenumbers.dp;

import java.util.Arrays;

//https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/#google_vignette
public class MatrixChainMultiplication {

    public static void main(String args[]) {
        int arr[] = new int[]{3, 3, 2, 1};
        int N = arr.length;
        int dp[][] = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);
        // Function call
        System.out.println(
                "Minimum number of multiplications is "
                        + MatrixChainOrder(arr, 1, N - 1, dp));
    }

    private static int MatrixChainOrder(int[] arr, int i, int j, int dp[][]) {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        for (int k = i; k < j; k++) {
            int result = MatrixChainOrder(arr, i, k, dp) + MatrixChainOrder(arr, k + 1, j, dp) +
                    arr[i - 1] * arr[k] * arr[j];
            min = Math.min(result, min);
        }
        dp[i][j] = min;
        return min;
    }
}
