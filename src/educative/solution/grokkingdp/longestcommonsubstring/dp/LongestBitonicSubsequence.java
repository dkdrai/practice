package educative.solution.grokkingdp.longestcommonsubstring.dp;

import java.util.Arrays;

public class LongestBitonicSubsequence{

    public static int lbsLengthHelper(int[] nums, int curr, int prev, int isDecreasing, int[][][] dp) {
        
        if (curr > nums.length) 
            return 0;
        

        if (dp[curr][prev][isDecreasing] != -1) 
            return dp[curr][prev][isDecreasing];
        

        // Base condition: If we're at the first element, we can make three choices
        // 1. Exclude the element in the subsequence
        // 2. Take the maximum length of including the next element in either the increasing, or decreasing part of the subsequence
        // The maximum length of including, or excluding the element is selected
        if (prev == 0) {
            int length1 = lbsLengthHelper(nums, curr + 1, prev, isDecreasing, dp);
    
                
            int length2 = Math.max(1 + lbsLengthHelper(nums, curr + 1, curr, isDecreasing, dp), 
                            1 + lbsLengthHelper(nums, curr + 1, curr, 1, dp));
            
            int length = Math.max(length1, length2);
            
            dp[curr][prev][isDecreasing] = length;
            return dp[curr][prev][isDecreasing];
        }
        
        // If isDecreasing is false, we are in the increasing part of the subsequence, so we can make three choices again
        // 1. Exclude the element in the subsequence
        // 2. If nums[curr] > nums[prev], take the maximum length of including the next element in either the increasing, or decreasing part of the subsequence
        // The maximum length of including, or excluding the element is selected
        if (isDecreasing == 0) {        

            int length1 = lbsLengthHelper(nums, curr + 1, prev, isDecreasing, dp);
            int length2 = 0;

            if (nums[curr - 1] > nums[prev - 1]) {
                length2 = Math.max(1 + lbsLengthHelper(nums, curr + 1, curr, isDecreasing, dp), 
                                1 + lbsLengthHelper(nums, curr + 1, curr, 1, dp));
            }

            int length = Math.max(length1, length2);
            dp[curr][prev][isDecreasing] = length;

        } 

        // Otherwise, if isDecreasing is true, we are in the decreasing part of the subsequence, so we can make two choices
        // 1. Exclude the element in the subsequence
        // 2. If nums[curr] < nums[prev], take the maximum length of including, or excluding the element
        else {
            int length = lbsLengthHelper(nums, curr + 1, prev, isDecreasing, dp);

            if (nums[curr - 1] < nums[prev - 1]) {
                length = Math.max(length, 1 + lbsLengthHelper(nums, curr + 1, curr, isDecreasing, dp));
            }

            dp[curr][prev][isDecreasing] = length;

        }
        return dp[curr][prev][isDecreasing];
    }


    public static int lbsLength(int[] nums){
        int n = nums.length;
        int[][][] dp = new int[n + 2][n + 2][3];

        for(int i = 0; i < n + 2; i++){
            for(int j = 0; j < n + 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return lbsLengthHelper(nums, 1, 0, 0, dp);
    }

  // Driver Code
  public static void main(String[] args){

    int[][] inputs = {{10}, {1, 8}, {2, 4, 1}, {6, 5, 3, 7, 10, 1, 2}, 
                      {1, 4, 9, 2, 16, 20}};

    // Let's uncomment this and check the effect of dynamic programming using memoization 
    // int temp[][] = Arrays.copyOf(inputs, inputs.length + 1);
    // temp[inputs.length] = new int[]{23, 11, 12, 10, 15, 12, 6, 15, 18, 4, 14, 2, 13, 25,
    //                                 27, 21, 2, 17, 18, 30, 22, 25, 10, 27, 10, 22, 21, 
    //                                 24, 26, 12, 26, 12, 3, 16, 4, 20, 18, 1, 5, 12, 10, 
    //                                 1, 14, 21, 15, 17, 21, 18, 13, 30, 20, 10, 5, 16, 9,
    //                                 4, 25, 10, 8, 15, 2, 1, 13, 9, 12, 13, 6, 28, 6, 26, 
    //                                 8, 20, 29, 9, 5, 14, 13, 30, 7, 3, 2, 24, 28, 21, 7, 
    //                                 19, 14, 22, 28, 2, 20, 8, 6, 27, 12, 8, 27, 2, 27, 
    //                                 30, 8, 23, 16, 27, 25, 3, 1, 3, 5, 18, 2, 13, 18, 28,
    //                                 2, 25, 20, 5, 11, 2, 28, 15, 15, 12, 25, 24, 17, 30,
    //                                 17, 7, 18, 23, 13, 4, 4, 23, 23, 18, 16, 18, 14, 11,
    //                                 26, 26, 22, 21, 23, 24, 24, 25, 20, 28, 18, 17, 21, 
    //                                 14, 16, 8, 19, 23, 26, 24, 28, 18, 26, 9, 22, 14, 15,
    //                                 1, 11, 23, 20, 16, 4, 16, 5, 30, 19, 18, 6, 14, 23,
    //                                 2, 1, 22, 29, 3, 29, 22, 30, 10, 30, 12, 17, 3, 12, 
    //                                 22, 8, 22};
    // inputs = temp;

    for (int i = 0; i < inputs.length; i++){
        System.out.println(i + 1 + ".\tnums: " + Arrays.toString(inputs[i]) +
                    "\n\n\tThe length of the longest bitonic subsequence is: " + lbsLength(inputs[i]));
                  
    }
  }
}