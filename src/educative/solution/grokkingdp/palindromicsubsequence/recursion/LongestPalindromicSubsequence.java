package educative.solution.grokkingdp.palindromicsubsequence.recursion;

import java.util.*;

public class LongestPalindromicSubsequence {
    public static int longestPalindromicSubsequence(String s) {
        int length = s.length();
        return longestPalindromicSubsequenceRecursive(s, 0, length - 1);
    }

    public static int longestPalindromicSubsequenceRecursive(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) return 0;

        // Every sequence with one element is a palindrome of length 1
        if (startIndex == endIndex) return 1;

        // Case 1: elements at the beginning and the end are the same
        if (s.charAt(startIndex) == s.charAt(endIndex))
            return 2 + longestPalindromicSubsequenceRecursive(s, startIndex + 1, endIndex - 1);

        // Case 2: skip one element either from the beginning or the end
        int c1 = longestPalindromicSubsequenceRecursive(s, startIndex + 1, endIndex);
        int c2 = longestPalindromicSubsequenceRecursive(s, startIndex, endIndex - 1);
        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        ArrayList < String > strings = new ArrayList < String > (
            Arrays.asList("cddpd", "abdbca", "racecar", "pqr")
        );

        // You can uncomment the lines below and check how this recursive solution causes a time-out

        // strings.add("aeqirradarqwruifdfgdtrrrraaadddaqweraarrr");

        int index = 0;
        for (String input: strings) {
            System.out.println((++index) + ". The length of the longest plaindromic subsequence in '" + input + "' is: " + longestPalindromicSubsequence(input));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}