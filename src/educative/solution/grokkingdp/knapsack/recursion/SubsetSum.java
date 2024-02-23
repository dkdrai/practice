package educative.solution.grokkingdp.knapsack.recursion;

import java.util.*;


/*The naive approach is to find all the possible combinations from the set, which makes our total. As we know, we are to trace down a subset and we can not repeat any element from the set. Therefore, every element in arr is considered only once.

For example, we have the following arr of positive values

arr: {3, 5, 8, 10}
and total =
13
13
. We return TRUE as the following two subsets sum up to the required total.

{
5
,
8
5,8
} such that
5
+
8
=
13
5+8=13
{
10
,
3
10,3
} such that
10
+
3
=
13
10+3=13
The recursive solution will be to check every element of the arr:

If it does not contribute to making up the total, we ignore that number and proceed with the rest of the elements, i.e., subsetSumRec(arr, n-1, total).
OR

If it does contribute to making up the total, we subtract the total from the current number and proceed with the rest of the elements till the given total is zero, i.e., subsetSumRec(arr, n-1, total-arr[n-1]).
Let’s try to implement the algorithm as discussed above:


Time complexity
The time complexity of the naive approach is
�
(
2
�
)
O(2
n
 )
, where
�
n
 is the total number of elements. This is because we have two possible choices every time, either to include the element or not.

Space complexity
As the maximum depth of the recursive call tree is
�
n
, and each call stores its data on the stack, the space complexity of this approach is
�
(
�
)
O(n)
.*/
class SubsetSum {
    public static boolean subsetSumRec(int [] sets, int n, int total)
    {
        // Base Cases
        if (total == 0)
            return true;
        
        if (n == 0)
            return false;
        
        // if last element is greater than total we ignore it
        if (sets[n-1] > total)
            return subsetSumRec(sets, n-1, total);
        
        // We either exclude the element or include the element
        return subsetSumRec(sets, n-1, total) || subsetSumRec(sets, n-1, total-sets[n-1]);
    }

    public static boolean subsetSum(int [] sets, int total)  // main function
    {
        int n = sets.length;
        return subsetSumRec(sets, n, total);
    }

    // driver code
    public static void main( String args[] ) {
        int[][] inputArr = {
            { 3, 5, 8 },
            { 2, 4, 7 },
            { 2, 3, 5 },
            { 1, 2, 3, 7 },
            { 10, 20, 23, 24 }
        };
        int[] total = { 13, 8, 5, 6, 57 };

        // You can uncomment the lines below and check how this recursive solution causes a time-out 
        
        // int newInputArr[][] = Arrays.copyOf(inputArr, inputArr.length + 1);
        // newInputArr[inputArr.length] = new int[]{0, 1, 4, 6, 7, 8, 9, 10, 11, 16, 17, 18, 21, 23, 25, 26, 28, 34,
        //      35, 36, 38, 39, 40, 41, 42, 44, 47, 50, 51, 54, 55, 61, 62, 63, 65, 69, 71, 72, 
        //      73, 75, 76, 78, 79, 80, 82, 83, 84, 85, 86, 88, 90, 91, 92, 93, 94, 98, 99, 100, 
        //      101, 103, 104, 106, 109, 116, 118, 119};
        // inputArr = newInputArr;

        // int newTotal[] = Arrays.copyOf(total, total.length + 1);
        // newTotal[total.length] = 2593;
        // total = newTotal;


        String result = new String("");
        for (int i = 0; i < total.length; i++)
        {
            if (subsetSum(inputArr[i], total[i]))
                result = "Yes.";
            else
                result = "No.";
            System.out.println(i + 1 + ".\tDoes a subset of " + Arrays.toString(inputArr[i]) + " sum up to " + total[i] + "?  " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}