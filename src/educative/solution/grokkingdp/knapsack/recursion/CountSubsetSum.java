package educative.solution.grokkingdp.knapsack.recursion;

import java.util.*;
/*
* The naive approach is to find the possible combinations from the set, which makes up our targetSum. We know that we have to trace down all subsets. Therefore, we have to evaluate every element of the set.

For example, we have the following set of positive values given along with a targetSum of
13
13
:

set:
{
{

3
,
5
,
8
,
10
3,5,8,10

}
}
The subsets whose sum will be equal to the targetSum are:

{
{

5
,
8
5,8

}
}
{
{

10
,
3
10,3

}
}
We cannot do
5
+
5
+
3
=
13
5+5+3=13
 because we can consider each element only once.

So, we need a recursive solution to make all these calculations, as shown above. In other words, we will divide our problem into smaller subproblems, starting from the start of the nums list and for each element, we will do the following steps:

Check for the following base cases:

If the targetSum is 0, it means that we can reach the sum of
0
0
 without including any element in our subset resulting in an empty subset, so we return 1 to include an empty subset.

If we have traversed all of our elements then we cannot proceed further to calculate the required sum. So we return 0.

Consider the current element for the required sum.

If it contributes to making up the targetSum, we subtract the targetSum from the current number and proceed on to the next number with the new target sum of targetSum – nums.get(currentIndex).
Do not consider the contribution of the current element for the targetSum and move on to consider the rest of the numbers.

Let’s try to implement the algorithm as discussed above:*/
class CountSubsetSum {

    // time O(2^n)
    // space O(n)
    // Main function
    public static long countSubsetSum(int [] nums, int targetSum) {
        return countSubsetSumRec(nums, targetSum, 0);
    }

    // Helper function
    public static long countSubsetSumRec(int [] nums, int targetSum, int currentIndex) {
        // base cases
        if (targetSum == 0) return 1;
        if (currentIndex >= nums.length) return 0;

        // if the number at currentIndex does not exceed the 
        // targetSum, we include it
        long sum1 = 0;
        if (nums[currentIndex] <= targetSum)
            sum1 = countSubsetSumRec(
                    nums,
                    targetSum - nums[currentIndex],
                    currentIndex + 1
            );

        // recursive call, excluding the number at the currentIndex
        long sum2 = countSubsetSumRec(nums, targetSum, currentIndex + 1);

        return sum1 + sum2;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputNums = {
                { 1 },
                { 11, 33 },
                { 4, 2, 3 },
                { 1, 4, 2, 3 },
                { 1, 2, 7, 4, 5 },
                { 1, 2, 3, 7 }
        };
        int[] targetSums = { 10, 11, 6, 4, 9, 6 };

        // You can uncomment the lines below and check how this recursive solution causes a time-out 
        // int newInputNums[][] = Arrays.copyOf(inputNums, inputNums.length + 1);
        // newInputNums[inputNums.length] = new int[]{1, 4, 6, 7, 8, 9, 10, 11, 16, 17, 18, 21,
        //     23, 25, 26, 28, 34, 35, 36, 38, 39, 40, 41, 42, 44, 47, 50,
        //     51, 54, 55, 61, 62, 63, 65, 69, 71, 72, 73, 75, 76, 78, 79,
        //     80, 82, 83, 84, 85, 86, 88, 90, 91, 92, 93, 94, 98, 99, 100,
        //     101, 103, 104, 106, 109, 116, 118, 119};
        // inputNums = newInputNums;

        // int newTargetSums[] = Arrays.copyOf(targetSums, targetSums.length + 1);
        // newTargetSums[targetSums.length] = 2593;
        // targetSums = newTargetSums;

        int index = 0;
        for (int [] input: inputNums) {
            System.out.println((index + 1) + ".\tnums = " + Arrays.toString(input));
            System.out.println("\ttarget sum = " + targetSums[index]);
            System.out.println("\tTotal number of subsets whose sum is equal to the target sum = " + countSubsetSum(input, targetSums[index]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            index++;
        }
    }
}