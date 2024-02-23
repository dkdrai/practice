package educative.solution.grokkingdp.unboundedknapsack.dp;

import java.util.*;

class RibbonCut {
    // time O(n∗k)
    // space O(n∗k)
    public static int countRibbonPiecesHelper(int[] sizes, int n, int index, int[][] dp) {
        // base case
        if (n == 0) {
            return 0;
        }

        int length = sizes.length;
        // if the length is zero or the index is greater than or equal to the length,
        // then return -1 as the ribbon cannot be cut further.
        if (length == 0 || index >= length) {
            return -1;
        }

        if (dp[index][n] == -1) {
            // recursive call after selecting the ribbon length at the index
            // if the ribbon length at the index exceeds the n, we shouldn't process this
            // since ribbon length is always positive, therefore initializing c1 with -1
            int c1 = -1;
            if (sizes[index] <= n) {
                int res = countRibbonPiecesHelper(sizes, n - sizes[index], index, dp);
                if (res != -1) {
                    // recursive call after excluding the ribbon length at the index
                    c1 = res + 1;
                }
            }
            int c2 = countRibbonPiecesHelper(sizes, n, index + 1, dp);
            dp[index][n] = Math.max(c1, c2);
        }

        return dp[index][n];
    }

    public static int countRibbonPieces(int n, int[] sizes) {
        int length = sizes.length;

        // we created a table here
        int[][] dp = new int[length][n + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        int result = countRibbonPiecesHelper(sizes, n, 0, dp);

        if (result == -1) {
            return -1;
        } else {
            return result;
        }
    }

    // driver code
    public static void main(String args[]) {
        int[][] sizes = { { 1, 2, 3 }, { 3, 2, 5 }, { 2, 3 }, { 3, 5, 7 }, { 5, 3 } };
        int[] n = { 5, 5, 7, 13, 7 };

        // Let's uncomment the below lines and check the effect of dynamic programming using memoization

        // sizes = Arrays.copyOf(sizes, sizes.length + 1);
        // sizes[sizes.length - 1] = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        // n = Arrays.copyOf(n, n.length + 1);
        // n[n.length - 1] = 1500;

        for (int i = 0; i < sizes.length; i++) {
            System.out.print((i + 1) + ".\tThe maximum number of sizes that can make up the n of ");
            System.out.print(n[i] + " from ");
            System.out.print(Arrays.toString(sizes[i]));
            System.out.println(" is: " + countRibbonPieces(n[i], sizes[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}