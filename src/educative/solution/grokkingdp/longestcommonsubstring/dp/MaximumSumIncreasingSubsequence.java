package educative.solution.grokkingdp.longestcommonsubstring.dp;

import java.util.*;

public class MaximumSumIncreasingSubsequence {

    public static int msisLength(int [] nums) {
        int length = nums.length;
        int sum = 0;
        // we created a table here
        int[][] dp = new int[length + 1][length + 2];
        for (int i = 0; i < length + 1; i++)
            for (int j = 0; j < length + 2; j++)
                dp[i][j] = -1;
        return msisLengthRec(nums, 0, -1, dp, sum);
    }

    private static int msisLengthRec(int [] nums, int curr, int prev, int[][] dp, int sum) {
        // base case
        // if 'curr' reaches the end of the array,  return the current sum
        if (curr == nums.length) {
            return sum;
        }

        // if subproblem has alredy been solved, use the stored result
        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        // solve the first subproblem
        int maxSum = msisLengthRec(nums, curr + 1, prev, dp, sum);

        // solve the second subproblem
        if (prev < 0 || nums[prev] < nums[curr]) {
            maxSum = Math.max(maxSum, sum + msisLengthRec(nums, curr + 1, curr, dp, nums[curr]));
        }

        dp[curr][prev + 1] = maxSum; // store the result of the current subproblem
        return dp[curr][prev + 1];
    }

    // driver code
    public static void main(String args[]) {
        int[][] lists = {
            { 4, 1, 2, 6, 10, 1, 12 },
            { -4, 10, 3, 7, 15 },
            { 4, 2, 3, 6, 10, 1, 12 },
            { 3, 2, 6, 4, 5, 1 },
            { 3, 2 },
            { 1, 2, 3, 4, 5, 6, 7 },
            { 1, 101, 2, 3, 100, 4, 5 },
            { 1, 5, 2, 3, 9, 5 }
        };

        //  You can uncomment the lines below and check how this recursive solution causes a time-out 

        // int newLists[][] = Arrays.copyOf(lists, lists.length + 1);
        // newLists[lists.length] = new int[]{20, 46, 6, 82, 88, 34, 85, 86, 58, 29, 71, 74, 6, 71, 14, 60, 97, 19, 76, 63,
        // 39, 100, 16, 69, 99, 95, 55, 41, 23, 57, 90, 65, 39, 93, 4, 25, 73, 96, 81, 92, 38, 74, 2,
        //  43, 38, 47, 48, 34, 44, 19, 48, 4, 41, 70, 86, 16, 92, 3, 9, 83, 72, 39, 72, 61, 73, 16, 53,
        //   17, 94, 77, 17, 70, 56, 11, 40, 81, 22, 5, 21, 34, 0, 88, 72, 6, 69, 67, 0, 97, 45, 97, 0, 32,
        //    85, 70, 30, 95, 89, 3, 9, 77, 67, 0, 97, 45, 97, 0, 32, 85, 70, 30, 95, 89, 3, 9, 77, 70, 30,
        //     95, 89, 3, 9, 77, 67, 0, 97, 45, 97, 0, 32, 85, 97, 0, 32, 85, 70, 30, 95, 89, 3, 9, 77, 70, 30,
        //     95, 89, 3, 9, 77, 67, 0, 97, 45, 197, 0, 32, 85, 45, 97, 0, 32, 19, 0, 32, 85, 45, 97, 40, 32, 78, 67};
        // lists = newLists;

        for (int i = 0; i < lists.length; i++) {
            MaximumSumIncreasingSubsequence msis = new MaximumSumIncreasingSubsequence();
            System.out.print((i + 1) + ". Input array: ");
            System.out.print(Arrays.toString(lists[i]));
            System.out.println("\nMaximum sum of increasing subsequence is: " + msis.msisLength(lists[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}