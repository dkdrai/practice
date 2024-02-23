package educative.solution.grokkingdp.knapsack.recursion;


/*
* A naive approach to this problem is to find all expressions using the given numbers and then count the number of expressions that evaluate to the given target.

For example, we have an array [2, 1, 2], and we can build the following expressions:

+
2
+
1
+
2
=
5
+2+1+2=5
+
2
−
1
+
2
=
3
+2−1+2=3
−
2
+
1
+
2
=
1
−2+1+2=1
−
2
−
1
+
2
=
−
1
−2−1+2=−1
+
2
+
1
−
2
=
1
+2+1−2=1
+
2
−
1
−
2
=
−
1
+2−1−2=−1
−
2
+
1
−
2
=
−
3
−2+1−2=−3
−
2
−
1
−
2
=
−
5
−2−1−2=−5
Now, for a given target, we can count the number of expressions that evaluate to that target. For example, if the target is –1, we can count that 2 expressions evaluate to –1.

The calculation above shows that we need a recursive solution to make all possible expressions. In other words, we divide the problem into subproblems, and for each number, we place a
+
+
 or
−
−
 before it and generate new expressions.

Let’s implement the algorithm as discussed above:
*
*
*
*
* Time complexity
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
 is the total number of integers. This is because we have two possible choices every time, either to assign a
+
+
 or a
−
−
 sign to the array elements.

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
.
* */
class TargetSum {


    // time O(2^n)
    // space O(n)
    public static int findTargetSumWaysRec(int[] arr, int i, int T){
        // If all integers are processed
        if (i == arr.length){
            // If target is reached
            if (T == 0)
                return 1;
            // If target is not reached
            return 0;
        }
    
        // Return total count of the following cases:
        //       1. Add current element to the target
        //       2. Subtract current element from the target
        return (findTargetSumWaysRec(arr, i + 1, T + arr[i]) +
                findTargetSumWaysRec(arr, i + 1, T - arr[i]));
    }

    public static int findTargetSumWays(int[] arr, int T){
        return findTargetSumWaysRec(arr, 0, T);
    }

    // Driver code
    public static void main(String args[] ) {
        int[][] arrs = {{1}, {3, 3, 3, 3}, {2, 3, 4, 6, 8, 12}, {2, 2, 2, 4, 4, 4, 8, 8, 8}};
        int[] targets = {1, 6, 15, 18};

        // Let's uncomment this to see the benefit of using dynamic programming with tabulation

        // int newArrs[][] = Arrays.copyOf(arrs, arrs.length + 1);
        // newArrs[arrs.length] = new int[]{2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3};
        // arrs = newArrs;

        // int newTargets[] = Arrays.copyOf(targets, targets.length + 1);
        // newTargets[targets.length] = 42;
        // targets = newTargets;    

        for (int i=0; i<arrs.length; ++i){
            String a =  "[" + arrs[i][0];
            for (int j=1; j<arrs[i].length; ++j)
                a = a + ", " + arrs[i][j];
            a += "]";
            System.out.println(i + 1 + ".\t Input array: " + a);
            System.out.println("\t Target: " + targets[i]);
            System.out.println("\t Number of ways in which we can find the target sum: " + findTargetSumWays(arrs[i], targets[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}