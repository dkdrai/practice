package educative.solution.grokkingdp.longestcommonsubstring.recursion;

import java.util.Arrays;

public class LongestBitonicSubsequence{

    /*
* Here is how the algorithm works:

Base case: If we’ve passed the end of the array, we return
0
0
.

If we’re at the first element, we have three choices:

Exclude the element from the subsequence by default.

Include the element in the subsequence and then take the maximum length of moving to either the increasing or decreasing part of the subsequence for the next element.

The maximum length of either, including or excluding the current element, is selected.

If isDecreasing is
0
0
, we’re in the increasing part of the subsequence. We now have three choices:

Exclude the element from the subsequence by default.

If nums[curr] > nums[prev], the element can be included to make a valid increasing subsequence; so, we include it and take the maximum length of moving to either the increasing or decreasing part of the subsequence for the next element.

We select the maximum length of the subsequence from either including or excluding the element from the above computations.

Otherwise, if isDecreasing is
1
1
, we’re in the decreasing part of the subsequence. We now have two choices:

Exclude the element from the subsequence by default.

If nums[curr] < nums[prev], the element can be included to make a valid decreasing subsequence; so, we take the maximum of either, including or excluding the number.

Let’s implement the algorithm as discussed above:


*/

    //O(3^n)
  public static int lbsLengthHelper(int[] nums, int curr, int prev, int isDecreasing){

      if (curr == nums.length) 
          return 0;

      // Base condition: If we're at the first element, we can make three choices
      // 1. Exclude the element in the subsequence
      // 2. Take the maximum length of including the next element in either the increasing, or decreasing part of the subsequence
      // The maximum length of including, or excluding the element is selected
      if (prev == -1){
          int length1 = lbsLengthHelper(nums, curr + 1, prev, isDecreasing);

          int length2 = Math.max(1 + lbsLengthHelper(nums, curr + 1, curr, isDecreasing),
                        1 + lbsLengthHelper(nums, curr + 1, curr, 1));

          int length = Math.max(length1, length2);

          return length;
      }

      // If isDecreasing is false, we are in the increasing part of the subsequence, so we can make three choices again
      // 1. Exclude the element in the subsequence
      // 2. If nums[curr] > nums[prev], take the maximum length of including the next element in either the increasing, or decreasing part of the subsequence
      // The maximum length of including, or excluding the element is selected
      if (isDecreasing == 0){
          int length1 = lbsLengthHelper(nums, curr + 1, prev, isDecreasing);
          int length2 = 0;

          if(nums[curr] > nums[prev]){
              
              length2 = Math.max(1 + lbsLengthHelper(nums, curr + 1, curr, isDecreasing),
                            1 + lbsLengthHelper(nums, curr + 1, curr, 1));
          }
              
          int length = Math.max(length1, length2);

          return length;
      }
          
      // Otherwise, if isDecreasing is true, we are in the decreasing part of the subsequence, so we can make two choices
      // 1. Exclude the element in the subsequence
      // 2. If nums[curr] < nums[prev], take the maximum length of including, or excluding the element
      else{
          int length = lbsLengthHelper(nums, curr + 1, prev, isDecreasing);
    
          if(nums[curr] < nums[prev])
              length = Math.max(length, 1 + lbsLengthHelper(nums, curr + 1, curr, isDecreasing));

          return length;
      }
  }


  public static int lbsLength(int[] nums){
      return lbsLengthHelper(nums, 0, -1, 0);
  }

  // Driver Code
  public static void main(String[] args){

    int[][] inputs = {{10}, {1, 8}, {2, 4, 1}, {6, 5, 3, 7, 10, 1, 2}, 
                      {1, 4, 9, 2, 16, 20}};

    // You can uncomment the lines below and check how this recursive solution causes a time-out
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