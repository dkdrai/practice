package educative.solution.grokkingdp.palindromicsubsequence.dp;

import java.util.*;

public class MinimumDeletions {
    public static int minimumDeletions(String s) {
        return s.length() - longestPalindromicSubsequence(s);
    }

    public static int longestPalindromicSubsequence(String s) {
        // Initializing a lookup table of dimensions len(s) x len(s)
        int lookupTable[][] = new int[s.length()][s.length()];
        for (int[] row : lookupTable)  
            Arrays.fill(row, 0); 
        
        return longestPalindromicSubsequenceRecursive(lookupTable, s, 0, s.length() - 1);
    }

    public static int longestPalindromicSubsequenceRecursive(int[][] lookupTable, String s, int start, int end) {
        if (start > end) 
            return 0;
        
        // Every sequence with one element is a palindrome of length 1
        if (start == end)
            return 1;

        if (lookupTable[start][end] == 0) {
            // case 1: elements at the beginning and the end are the same
            if (s.charAt(start) == s.charAt(end))
                lookupTable[start][end] = 2 + longestPalindromicSubsequenceRecursive(lookupTable, s, start + 1, end - 1);
            // case 2: skip one element either from the beginning or the end
            else {
                int c1 = longestPalindromicSubsequenceRecursive(lookupTable, s, start + 1, end);
                int c2 = longestPalindromicSubsequenceRecursive(lookupTable, s, start, end - 1);
                lookupTable[start][end] = Math.max(c1, c2);
            }
        }
        return lookupTable[start][end];
    }

    // Driver code
    public static void main(String[] args) {
        ArrayList < String > strings = new ArrayList < String > (
            Arrays.asList("raddar", "lleveal", "aqwrqhanisahinahqwe", "pqr")
        );

        // Let's uncomment this and check the effect of dynamic programming using memoization

        // strings.add("aeqirradarqwruifdfgdtrrrraaadddaqweraarrr");

        int index = 0;
        for (String input: strings) {
            System.out.println((++index) + ". The minimum deletions required to make '" + input + "' a palindrome is: " + minimumDeletions(input));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}