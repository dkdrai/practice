package educative.solution.grokkingdp.recursivenumbers.dp;

import java.util.*;

class MinJumps {
    public static long findMinJumps(int[] nums) {
        // Initializing the lookup table of nums length
        long[] lookup = new long[nums.length];
        Arrays.fill(lookup, Integer.MAX_VALUE);
        return findMinJumpsMemo(lookup, nums, 0);
    }

    public static long findMinJumpsMemo(long[] lookup, int[] nums, int index) {
        int n = nums.length;
        // If we have reached the last index
        if (index >= n - 1)
            return 0;

        // If we have already solved this problem, return the result
        if (lookup[index] != Integer.MAX_VALUE)
            return lookup[index];

        // Initializing jumps with maximum value. It will store
        // the minimum jumps required to reach the current index
        long jumps = Integer.MAX_VALUE;

        // Checking all the possible jumps
        for (int i = index + 1; i <= index + nums[index]; i++) {
            // Selecting the minimum jump
            jumps = Math.min(jumps, findMinJumpsMemo(lookup, nums, i) + 1);
        }

        // Storing the value in lookup table
        lookup[index] = jumps;
        return lookup[index];
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
            {1, 7},
            {2, 1, 0},
            {5, 2, 3, 1, 1, 4},
            {5, 2, 1, 1, 1, 4},
            {9, 1, 1, 3, 6, 9, 3, 0, 1, 3}
        };
        // Let's uncomment the below lines and check the effect of dynamic programming using memoization
        // int[] largeInput = {2, 9, 4, 6, 1, 4, 7, 10, 0, 3, 9, 7, 4, 10, 5, 9, 3, 9, 7, 7, 10, 1, 8, 5, 9, 3, 1, 5, 9, 7, 7, 6, 3, 9, 7, 0, 1, 9, 9, 0, 9, 4, 9, 6, 2, 9, 3, 7, 6, 4};

        // inputs = Arrays.copyOf(inputs, inputs.length + 1);
        // inputs[inputs.length - 1] = largeInput;

        for (int i = 0; i < inputs.length; i++) {
            System.out.println(i + 1 + ".\t" + Arrays.toString(Arrays.copyOfRange(inputs[i], 1, inputs[i].length)));
            System.out.println("\tMinimum jumps to reach the end: " + findMinJumps(Arrays.copyOfRange(inputs[i], 1, inputs[i].length)));
            System.out.println(new String(new char[100]).replace('\0', '-') + '\n');
        }
    }
}