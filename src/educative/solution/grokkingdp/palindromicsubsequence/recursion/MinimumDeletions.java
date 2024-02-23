package educative.solution.grokkingdp.palindromicsubsequence.recursion;

import java.util.*;

public class MinimumDeletions {
    public static int minimumDeletions(String s) {
        int length = s.length();
        return length - longestPalindromicSubsequence(s, 0, length - 1);
    }

    public static int longestPalindromicSubsequence(String s, int start, int end) {
        if (start > end) return 0;

        // Every sequence with one element is a palindrome of length 1
        if (start == end) return 1;

        // Case 1: elements at the beginning and the end are the same
        if (s.charAt(start) == s.charAt(end))
            return 2 + longestPalindromicSubsequence(s, start + 1, end - 1);

        // Case 2: skip one element either from the beginning or the end
        int c1 = longestPalindromicSubsequence(s, start + 1, end);
        int c2 = longestPalindromicSubsequence(s, start, end - 1);
        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        ArrayList < String > strings = new ArrayList < String > (
            Arrays.asList("raddar", "lleveal", "aqwrqhanisahinahqwe", "pqr")
        );

        // You can uncomment the lines below and check how this recursive solution causes a time-out

        // strings.add("aeqirradarqwruifdfgdtrrrraaadddaqweraarrr");

        int index = 0;
        for (String input: strings) {
            System.out.println((++index) + ". The minimum deletions required to make '" + input + "' a palindrome is: " + minimumDeletions(input));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}