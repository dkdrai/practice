package educative.solution.grokkingdp.recursivenumbers.recursion;

import java.util.*;
import java.util.stream.*;

//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
class Solution {

    public static long minMultiplications(int[] dims) {
        // Base case
        if (dims.length <= 2) {
            return 0;
        }
        long minimum = Long.MAX_VALUE; // Init with maximum integer value
        for (int i = 1; i < dims.length - 1; i++) { // Recursive calls for all the possible mulitplication sequences
            minimum = Math.min(minimum, minMultiplications(Arrays.copyOfRange(dims, 0, 0 + (i + 1))) + // solve the subproblem up to the ith matrix
                minMultiplications(Arrays.copyOfRange(dims, 0 + i, dims.length)) + // solve the subproblem from the i+1th matrix to the last
                dims[0] * dims[dims.length - 1] * dims[i]); // calculate the number of multiplications for the 
        } // current pair of matrices with dimensions dims[0]xdims[i] and dims[i]xdims[-1]
        return minimum;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] dims = {
            {3, 3, 2, 1},
            {4, 3, 2, 1},
            {2, 2, 2},
            {1, 1, 1},
            {13, 16, 11, 99, 3}};
        // You can uncomment the lines below and check how this recursive solution causes a time-out 
        // int temp[][] = Arrays.copyOf(dims, dims.length + 1); 
        // temp[dims.length] = new int[]{13, 16, 11, 99, 3, 13, 16, 11, 99, 3, 13, 16, 11, 99, 3, 13, 16, 11, 99, 3, 13, 16, 11, 99, 3, 13, 16, 11, 99, 3};
        // dims = temp;

        for (int i = 0; i < dims.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput dims: " + Arrays.toString(dims[i]));
            System.out.println("\n\tThe least number of primitive multiplications possible: " + minMultiplications(dims[i]));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }

    }

}