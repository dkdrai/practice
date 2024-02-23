package educative.solution.grokkingdp.palindromicsubsequence.dp;

import java.util.*;

class LongestPalindromicSubstring {
    public static int findLpsLengthRecursion(int[][] dp, String s, int start, int end){

        // if both pointers are pointing to the same index
        if (start==end)
            return 1;

        if (dp[start][end] == -1){
        
            // the characters at start and end indices match
            if (s.charAt(start)==s.charAt(end)){
                int subStringLength = end - start + 1;

                // if the substring length is 2 and it's also a palindrome
                if (subStringLength == 2)
                    return 2;

                // check whether the remainig string is a palindrome
                if (subStringLength == 2 + findLpsLengthRecursion(dp, s, start+1, end-1)){
                    dp[start][end] = subStringLength;
                    return dp[start][end];
                }
            }
            // skip one element either from the beginning or end and select the maximum resultant value
            dp[start][end] = Math.max(findLpsLengthRecursion(dp, s, start+1, end), findLpsLengthRecursion(dp, s, start, end-1));
        }

        return dp[start][end];
    }

    public static int findLpsLength(String s){
        // initialize a lookup table
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        
        return findLpsLengthRecursion(dp, s, 0, s.length()-1);
    }

    // Driver code
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>(
            Arrays.asList("abcbda", "tworacecars", "pqrssrqp", "mnop", "bbbbbbbbbbbbbbbbbbbb"));
        
        // Let's uncomment this and check the effect of dynamic programming using memoization
        // strings.add("mwusjunybvgafxuhloqwfoizqkkqzilltjw");

        for (int i=0; i<strings.size(); ++i){
            System.out.println(i+1+".\t Input string: '" + strings.get(i) + "'");
            System.out.println("\t Length of the longest palindromic substring: " + findLpsLength(strings.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}