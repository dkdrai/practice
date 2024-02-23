package educative.solution.grokkingdp.unboundedknapsack.recursion;

import java.util.*;

class RibbonCut {

    //Time complexity
    //The time complexity of the naive approach is
    //�
    //(
    //2
    //�
    //)
    //O(2
    //n
    // )
    //, where
    //�
    //n
    // is the total length of the ribbon.
    //
    //Space complexity
    //The space complexity is
    //�
    //(
    //�
    //+
    //�
    //)
    //O(n+k)
    // where
    //�
    //n
    // is the total length of the ribbon, and
    //�
    //k
    // is sizes.length.
    public static int countRibbonPiecesHelper(int[] arr, int n, int index) {
        // base case
        if (n == 0) {
            return 0;
        }

        int length = arr.length;

        // if the length is zero or the index is greater than or equal to the length,
        // then return -1 as the ribbon cannot be cut further.
        if (length == 0 || index >= length) {
            return -1;
        }

        // recursive call after selecting the ribbon length at the index
        // if the ribbon length at the index exceeds n, we shouldn't process this
        // since ribbon length is always positive, therefore initializing c1 with -1
        int c1 = -1;

        if (arr[index] <= n) {
            int maxSize = countRibbonPiecesHelper(arr, n - arr[index], index);
            if (maxSize != -1) {
                c1 = maxSize + 1;
            }
        }
        // recursive call after excluding the ribbon length at the curr
        int c2 = countRibbonPiecesHelper(arr, n, index + 1);
        return Math.max(c1, c2);
    }

    public static int countRibbonPieces(int n, int[] arr) {
        int maximum = countRibbonPiecesHelper(arr, n, 0);
        if (maximum == -1) {
            return -1;
        } else {
            return maximum;
        }
    }

    // driver code
    public static void main(String args[]) {
        int[][] sizes = { { 1, 2, 3 }, { 3, 2, 5 }, { 2, 3 }, { 3, 5, 7 }, { 5, 3 } };
        int[] n = { 5, 5, 7, 13, 7 };

        // You can uncomment the lines below and check how this recursive solution causes a time-out

        // sizes = Arrays.copyOf(sizes, sizes.length + 1);
        // sizes[sizes.length - 1] = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        // n = Arrays.copyOf(n, n.length + 1);
        // n[n.length - 1] = 1500;

        for (int i = 0; i < sizes.length; i++) {
            System.out.print((i + 1) + ".\tThe maximum number of sizes that can make up the n of ");
            System.out.print(n[i] + " from ");
            System.out.print(Arrays.toString(sizes[i]));
            System.out.println(" is: " + countRibbonPieces(n[i], sizes[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}