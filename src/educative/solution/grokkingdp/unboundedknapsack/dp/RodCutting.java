package educative.solution.grokkingdp.unboundedknapsack.dp;

import java.util.Arrays;

class RodCutting {


    // time O(n * m)
    //space O(n * m)

    public static int rodCutting(int[] lengths, int[] prices, int n) {
        // Base case
        if (prices.length == 0 || prices.length != lengths.length)
            return 0;

        // Creating a lookup table of size lengths.length x (n + 1)
        int[][] dp = new int[lengths.length][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return rodCuttingRec(lengths, prices, n, 0, dp);
    }

    // Helper function
    public static int rodCuttingRec(int[] lengths, int[] prices, int n, int curr, int[][] dp) {
        // base case
        if (n == 0 || curr == lengths.length)
            return 0;

        // If a piece of size lengths[curr] is not already computed 
        // for a rod of length n, compute it
        if (dp[curr][n] == -1) {
            // Cut the piece of size length[curr]
            int revenue1 = 0;
            if (lengths[curr] <= n)
                revenue1 = prices[curr] + rodCuttingRec(lengths, prices, n - lengths[curr], curr, dp);

            // Don't cut the piece from the rod and move to the next available length
            int revenue2 = rodCuttingRec(lengths, prices, n, curr + 1, dp);

            // store the max in the lookup table
            dp[curr][n] = Math.max(revenue1, revenue2);
        }

        // return from the lookup table
        return dp[curr][n];
    }

    public static void main(String[] args) {
        int[] n = {3, 4, 8, 4, 6};
        int[][] lengths = {
            {1, 2, 3},
            {2, 3, 4},
            {2, 1},
            {4, 3, 2, 1},
            {1, 2, 5, 4, 6}
        };
        int[][] prices = {
            {7, 3, 8},
            {2, 7, 8},
            {20, 10},
            {1, 1, 1, 6},
            {2, 8, 9, 10, 11}
        };

        // Let's uncomment the below lines and check the effect of dynamic programming using memoization

        // n = Arrays.copyOf(n, n.length + 1);
        // n[n.length - 1] = 100;
        // int[][] pricesNew = Arrays.copyOf(prices, prices.length + 1);
        // int[] pricesList = new int[100];
        // for (int i = 1; i < 200; i = i+2)
        //     pricesList[(i - 1)/2] = i; // populating prices
        // pricesNew[prices.length] = pricesList;
        // int[][] lengthsNew = Arrays.copyOf(lengths, lengths.length + 1);
        // int[] lengthsList = new int[100];
        // for (int i = 1; i < 101; i++)
        //     lengthsList[i - 1] = i; // populating lengths
        // lengthsNew[lengths.length] = lengthsList;
        
        // prices = pricesNew;
        // lengths = lengthsNew;

        for (int i = 0; i < n.length; i++) {
            System.out.println(i + 1 + ". Rod length: " + n[i]);
            System.out.println("\tLengths: " + Arrays.toString(lengths[i]));
            System.out.println("\tPrices: " + Arrays.toString(prices[i]));

            int result = rodCutting(lengths[i], prices[i], n[i]);
            System.out.println("\tThe maximum profit found: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}