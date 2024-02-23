package educative.solution.grokkingdp.unboundedknapsack.dp;

import java.util.*;

public class MinimumCoinChange {
    // Helper function that calculates amount left to be 
    // calculated and tells what it's value can be.


    public static int coinChange(int [] coins, int total) {

        // write your code here
        int dp[][] = new int[coins.length][total+1];
        for(int i =0; i<coins.length; i++)
            Arrays.fill(dp[i], -1);
        return minCoins(coins, 0, total,dp);
    }



    public static int minCoins(int []coins, int i, int total, int dp[][]){
        if(total == 0)
            return 0;
        if(total < 0 || i == coins.length)
            return -1;
        if(dp[i][total] != -1)
            return dp[i][total];
        int ans1 = minCoins(coins, i, total - coins[i],dp);
        int ans2 = minCoins(coins, i+1, total,dp);
        if(ans1 != -1 && ans2 != -1)
            return dp[i][total]=  Math.min(ans1 +1, ans2);
        if(ans1 != -1)
            return dp[i][total] =ans1 +1;
        if(ans2 != -1)
            return dp[i][total] = ans2  ;
        return dp[i][total] = -1;
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