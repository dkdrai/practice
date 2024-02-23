package educative.solution.grokkingdp.longestcommonsubstring.recursion;// Importing required functions
import java.util.*;

public class LongestRepeatingSubsequence {
	static int findLRS(String str) {
		return findLRSRecursive(str, str.length(), str.length());
	}

  	static int findLRSRecursive(String str, int p1, int p2) {
		// Base case if any one index has reached end
		if ((p1 == 0) || (p2 == 0))
			return 0;

		// Characters are same but indexes are different
		if ((str.charAt(p1 - 1) == str.charAt(p2 - 1)) && (p1 != p2))
			return findLRSRecursive(str, p1 - 1, p2 - 1) + 1;

		// Check if the characters at both indexes don't match
		return Math.max(
			findLRSRecursive(str, p1, p2 - 1), findLRSRecursive(str, p1 - 1, p2)
		);
	}

	// Driver code
	public static void main(String[] args) {
		ArrayList<String> inputs = new ArrayList<String>(
			Arrays.asList("abcd", "abddccd", "abbaba", "aaaaba", "abcdaeda")
		);

		// You can uncomment the line below and check how this recursive solution causes a time-out 
		// inputs.add("abcdefghijklmnopqrstuv");

		for (int i = 0; i < inputs.size(); i++) {
      		System.out.println(i + 1 + ". String: " + inputs.get(i));
			System.out.println("Longest repeating subsequence is " + findLRS(inputs.get(i)));
			System.out.println(new String(new char[100]).replace('\0', '-') + '\n');
    	}
	}
}