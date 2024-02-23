package educative.solution.grokkingdp.unboundedknapsack.recursion;

import java.util.*;

public class CoinChangeII {
    public static long countWays(int[] coins, int amount) {

        // Replace this placeholder return statement with your code
        List<List<Integer>> result = new ArrayList<>();

        long ways = util(coins, amount, 0, result, new ArrayList<>());
        System.out.println(result);
        return ways;
    }

    public static long util(int coins[], int amount, int i, List<List<Integer>> result, List<Integer> sublist) {
        if (amount == 0) {
            result.add(new ArrayList<>(sublist));
            return 1;
        }
        if (amount < 0 || i == coins.length)
            return 0;

        long count1 = util(coins, amount, i + 1, result, sublist);
        sublist.add(coins[i]);
        long count2 = util(coins, amount - coins[i], i, result, sublist);
        sublist.remove(sublist.size() - 1);
        return count1 + count2;
    }

    public static void main(String[] args) {
        int coins[] = {10, 20};
        int amount = 50;
        System.out.println(countWays(coins, amount));
    }
}


