package educative.solution.grokkingdp.unboundedknapsack.dp;

import java.util.*;

public class CoinChangeII{
    public static long countWays (int[] coins, int amount) {

        // Replace this placeholder return statement with your code
        long dp[][] = new long [coins.length][amount+1];
        for(int i =0; i<coins.length; i++)
        Arrays.fill(dp[i], -1);

        return util(coins, amount, 0, dp);
    }

    public static long util(int coins[], int amount, int i, long dp[][]){
        if(amount == 0)
        return 1;
        if(amount <0 || i == coins.length)
        return 0;
        if(dp[i][amount] != -1)
        return dp[i][amount];
        return dp[i][amount] = util(coins, amount, i+1,dp) + util(coins, amount - coins[i], i,dp);
    }
}