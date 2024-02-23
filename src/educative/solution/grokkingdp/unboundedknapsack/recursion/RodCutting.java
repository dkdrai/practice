package educative.solution.grokkingdp.unboundedknapsack.recursion;

import java.util.Arrays;

class RodCutting {


    // time O(2^n)
    // space O(n)
    public static int rodCutting(int[] lengths, int[] prices, int n) {
        if (prices.length == 0 || prices.length != lengths.length)
            return 0;
        return rodCuttingRec(lengths, prices, n, 0);
    }

    public static int rodCuttingRec(int[] lengths, int[] prices, int n, int curr) {
        // base case
        if (n == 0 || curr == lengths.length)
            return 0;

        // Cut the piece of size lengths[curr]
        int revenue1 = 0;
        if (lengths[curr] <= n)
            revenue1 = prices[curr] + rodCuttingRec(lengths, prices, n - lengths[curr], curr);

        // Don't cut the piece from the rod and move to the next available length
        int revenue2 = rodCuttingRec(lengths, prices, n, curr + 1);

        // return the maximum of both revenues
        return Math.max(revenue1, revenue2);
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

        // You can uncomment the lines below and check how this recursive solution causes a time-out

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