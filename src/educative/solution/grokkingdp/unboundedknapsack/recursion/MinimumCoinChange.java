package educative.solution.grokkingdp.unboundedknapsack.recursion;

import java.util.*;

public class MinimumCoinChange {
    // Helper function that calculates amount left to be 
    // calculated and tells what it's value can be.


    static int coinChange(int[] coins, int amount) {
        return coinChangeHelper(coins, 0, amount);
    }


    static int coinChangeHelper(int[] coins, int start, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (start == coins.length) {
            return -1;
        }
        if (amount < 0) {
            return -1;
        }
        // Recursive calls
        int ans1 = coinChangeHelper(coins, start, amount - coins[start]);
        int ans2 = coinChangeHelper(coins, start + 1, amount);
        if (ans1 != -1 && ans2 != -1) {
            return Math.min(ans1 + 1, ans2);
        }
        // If we cannot achieve that amount through recursive call 1
        if (ans1 == -1) {
            return ans2;
        }
        // If we cannot achieve that amount through recursive call 2
        if (ans2 == -1) {
            return (ans1 + 1);
        }
        return -1;
    }


    // Driver Code
    public static void main(String args[]) {
        int[][] coins = {
                {1, 3, 4, 5},
                {1, 2, 3},
                {2, 3, 7},
                {1, 3, 9},
                {1, 4, 6, 9}
        };
        int[] total = {7, 5, 1, 4, 11};

        //   You can uncomment the lines below and check how this recursive solution causes a time-out

        int newCoins[][] = Arrays.copyOf(coins, coins.length + 1);
        newCoins[coins.length] = new int[]{10, 34, 200, 415};
        coins = newCoins;

        int newTotal[] = Arrays.copyOf(total, total.length + 1);
        newTotal[total.length] = 710;
        total = newTotal;

        for (int i = 0; i < total.length; i++) {
            System.out.println(i + 1 + ".\tThe minimum number of coins required to find " + total[i] + " from " + Arrays.toString(coins[i]) + " is: " + coinChange(coins[i], total[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}