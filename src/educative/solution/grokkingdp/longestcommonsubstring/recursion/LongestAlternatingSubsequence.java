package educative.solution.grokkingdp.longestcommonsubstring.recursion;

import java.util.*;
import java.util.stream.*;

public class LongestAlternatingSubsequence {

    // Helper function
    public static int LASRec(int[] nums, int previous, int current, boolean isAsc) {
        /*
            Recursively calculate the longest alternating ssubsequence
            :param nums: Sequence of integer numbers (array of integers)
            :param previous: Index of the previous element 
            :param current: Index of the current element 
            :param isAsc: Indicates whether the current element is in ascending order relative to the previous
            return: Length of longest alternating subsequence for the given subproblem
        */
        // Base case
        if (current == nums.length) {
            return 0;
        }
        int count = 0;

        // If the current element is bigger than the previous and flag is ascending
        // Increment count by 1, flip the flag and move to the next element
        if (nums[current] > nums[previous] && isAsc) {
            count = 1 + LASRec(nums, current, current + 1, !isAsc);
        }

        //  If the current element is smaller than the previous and flag is descending
        //  Increment count by 1, flip the flag and move to the next element
        else if (nums[current] < nums[previous] && !isAsc) {
            count = 1 + LASRec(nums, current, current + 1, !isAsc);
        }

        // Iterate over the remaining sequence
        int count2 = Math.max(count, LASRec(nums, previous, current + 1, isAsc));

        return count2;
    }

    public static int LAS(int[] nums) {
        // We have to start with two recursive calls, one where we will consider that the first element is
        // bigger than the second element and one where the first element is smaller than the second element
        // +1 is for the zero index count, that we are skipping and starting our current index from 1
        return Math.max(LASRec(nums, 0, 1, true), LASRec(nums, 0, 1, false)) + 1;
    }

    public static void main(String[] args) {
        int[][] nums = {
            {1, 3, 2, 5},
            {1, 2, 3, 4},
            {4, 3, 2, 1},
            {5, 5, 5, 5, 5},
            {9, 6, 4, 5, 6, 3}};

        // You can uncomment the lines below and check how this recursive solution causes a time-out 
        // int temp[][] = Arrays.copyOf(nums, nums.length + 1); 
        // temp[nums.length] = new int[]{1, 6, 4, 8, 2, 9, 4, 1, 7, 11, 23, 65, 34, 23, 45, 34, 34, 32, 32, 21, 67, 89, 76, 77, 66, 44, 89, 0, 1, 2, 3, 5, 4, 2, 5, 6, 43, 2, 4, 5, 2, 55, 66, 1, 6, 4, 8, 2, 9, 4, 1, 7, 11, 23, 65, 34, 23, 45, 34, 34, 32, 32, 21, 67, 89, 76, 77, 66, 44, 89, 0, 1, 2, 3, 5, 4, 2, 5, 6, 43, 2, 4, 5, 2, 55, 66};
        // nums = temp;

        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tNums: " + Arrays.toString(nums[i]));
            System.out.println("\n\tThe Length of Longest Alternating Subsequence is: " + LAS(nums[i]));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }
    }
}