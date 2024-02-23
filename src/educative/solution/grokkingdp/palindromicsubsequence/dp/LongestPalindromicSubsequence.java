package educative.solution.grokkingdp.palindromicsubsequence.dp;

import java.util.*;

public class LongestPalindromicSubsequence {
    public static int longestPalindromicSubsequence(String s) {
        // Initializing a lookup table of dimensions len(s) x len(s)
        int lookupTable[][] = new int[s.length()][s.length()];
        for (int[] row : lookupTable)  
            Arrays.fill(row, 0); 
        
        return longestPalindromicSubsequenceRecursive(lookupTable, s, 0, s.length() - 1);
    }

    public static int longestPalindromicSubsequenceRecursive(int[][] lookupTable, String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) 
            return 0;
        
        // Every sequence with one element is a palindrome of length 1
        if (startIndex == endIndex)
            return 1;

        if (lookupTable[startIndex][endIndex] == 0) {
            // case 1: elements at the beginning and the endIndex are the same
            if (s.charAt(startIndex) == s.charAt(endIndex))
                lookupTable[startIndex][endIndex] = 2 + longestPalindromicSubsequenceRecursive(lookupTable, s, startIndex + 1, endIndex - 1);
            // case 2: skip one element either from the beginning or the endIndex
            else {
                int c1 = longestPalindromicSubsequenceRecursive(lookupTable, s, startIndex + 1, endIndex);
                int c2 = longestPalindromicSubsequenceRecursive(lookupTable, s, startIndex, endIndex - 1);
                lookupTable[startIndex][endIndex] = Math.max(c1, c2);
            }
        }
        return lookupTable[startIndex][endIndex];
    }

    // Driver code
    public static void main(String[] args) {
        ArrayList < String > strings = new ArrayList < String > (
            Arrays.asList("cddpd", "abdbca", "racecar", "pqr")
        );

        // Let's uncomment this and check the effect of dynamic programming using memoization

        // strings.add("foasaqerfeotballqwrthuasllabqweroot");

        int index = 0;
        for (String input: strings) {
            System.out.println((++index) + ". The length of the longest palindromic subsequence in '" + input + "' is: " + longestPalindromicSubsequence(input));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}