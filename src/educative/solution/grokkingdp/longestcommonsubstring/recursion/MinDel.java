package educative.solution.grokkingdp.longestcommonsubstring.recursion;

import java.util.Arrays;

//Minimum Deletions to Make a Sequence Sorted
class MinDel {

    // O(2^n)
    public static int minDeletions(int[] nums) {
        // subtract length of longest increasing subsequence from total length
        int minDel = nums.length - lisLength(nums, 0, -1);
        return minDel;
    }

    private static int lisLength(int[] nums, int curr, int prev) {
        // base case
        // if 'curr' reaches the end of the array, return 0
        if (curr == nums.length) {
            return 0;
        }

        // solve the first subproblem
        int length = lisLength(nums, curr + 1, prev); // calculate the LIS length from 'curr+1', skipping the current element

        // solve the second subproblem
        if (prev < 0 || nums[prev] < nums[curr]) // if the current element is greater than the previous one in the subsequence
        {
            length = Math.max(length, 1 + lisLength(nums, curr + 1, curr)); // calculate the LIS length from 'curr+1', including the current element
        }
        return length;
    }

    // driver code
    public static void main(String args[]) {
        int[][] arrays = {
            {1, 3, 6, 7, 9, 4, 10, 5, 6},
            {10, 9, 2, 5, 3, 7, 101, 18},
            {30, 40, 2, 5, 1, 7, 45, 50, 8},
            {0, 1, 0, 3, 2, 3},
            {3, 2},
            {6, 9, 8, 2, 3, 5, 1, 4, 7},
            {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15},
            {9, 2, 5, 3, 6, 14, 11, 7, 9, 5, 13, 3, 15, 0, 8, 4, 1, 9, 5, 13, 3, 11, 7, 15, 0, 10, 6, 14, 9, 2, 5, 3, 2, 10, 6, 10, 6, 5, 13, 3, 11, 7, 15, 3, 11, 7, 15}
        };
        // You can uncomment the lines below and check how this recursive solution causes a time-out

        // int[] array = {
        //     72, 56, 13, 33, 4, 5, 53, 14, 71, 42, 5, 74, 60, 15, 68, 42, 56, 58, 67, 32,
        //     65, 75, 47, 29, 86, 32, 77, 39, 19, 54, 54, 18, 49, 34, 89, 85, 63, 86, 90, 53,
        //     35, 2, 65, 63, 90, 26, 39, 41, 38, 32, 21, 35, 51, 34, 50, 27, 51, 94, 70, 94,
        //     18, 89, 45, 40, 13, 56, 25, 59, 51, 6, 59, 56, 41, 44, 23, 26, 83, 8, 0, 33,
        //     59, 43, 83, 40, 24, 86, 28, 2, 23, 87, 11, 23, 13, 48, 20, 64, 21, 93, 8, 70,
        //     33, 48, 10, 29, 24, 59, 92, 23, 67, 79, 54, 7, 56, 5, 2, 63, 88, 58, 60, 95,
        //     54, 7, 56, 5, 2, 63, 88, 58, 60, 95, 54, 7, 56, 5, 2, 63, 88, 58, 60, 95,
        //     54, 7, 56, 5, 2, 63, 88, 58, 60, 95
        // };

        // arrays = Arrays.copyOf(arrays, arrays.length + 1);
        // arrays[arrays.length - 1] = array;

        for (int i = 0; i < arrays.length; i++) {
            System.out.println((i + 1) + ".\tInput array: "+ Arrays.toString(arrays[i]));
            System.out.println("\n\tMinimum deletions required: " + minDeletions(arrays[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}