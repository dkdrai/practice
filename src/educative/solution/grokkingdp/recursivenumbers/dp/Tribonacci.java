package educative.solution.grokkingdp.recursivenumbers.dp;

import java.util.*;

class Tribonacci {

    //O(n)
    public static long tribonacci(int n) {
        long[] cache = new long[n + 1];
        Arrays.fill(cache, 0);
        return tribonacciHelper(n, cache);
    }

    public static long tribonacciHelper(int n, long cache[]) {
        // Base cases
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;

        // Using memoization table to get the already evaluated result
        if (cache[n] != 0)
            return cache[n];

        cache[n] = tribonacciHelper(n - 1, cache) +
            tribonacciHelper(n - 2, cache) +
            tribonacciHelper(n - 3, cache);

        return cache[n];
    }

    public static void main(String[] args) {
        ArrayList < Integer > n = new ArrayList < Integer > (
            Arrays.asList(4, 5, 25, 17, 19)
        );

        // Let's uncomment this and check the effect of dynamic programming using memoization

        // n.add(45);

        int index = 0;
        for (int input: n) {
            System.out.println((++index) + ".\tThe " + input + "th Tribonacci number is:  " +
                tribonacci(input));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}