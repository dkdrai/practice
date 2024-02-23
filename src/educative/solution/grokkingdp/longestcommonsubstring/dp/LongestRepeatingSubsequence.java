package educative.solution.grokkingdp.longestcommonsubstring.dp;// Importing required functions
import java.util.*;

public class LongestRepeatingSubsequence {
	static int findLRS(String str) {
		Map<String, Integer> lookupTable = new HashMap<>();
		return findLRSMemoization(str, str.length(), str.length(), lookupTable);
	}

  	static int findLRSMemoization(String str, int p1, int p2, Map<String, Integer> lookupTable) {
		// Base case if any one index has reached end
		if ((p1 == 0) || (p2 == 0))
			return 0;

		// Creating a key to store in map
		String key = p1 + "," + p2;

		// Checking if unique pair not in lookup table
		if (!lookupTable.containsKey(key)) {
			// Characters are same but indexes are different
			if ((str.charAt(p1 - 1) == str.charAt(p2 - 1)) && (p1 != p2)) {
				lookupTable.put(key, findLRSMemoization(str, p1 - 1, p2 - 1, lookupTable) + 1);
			}
			// Check if the characters at both indexes don't match
			else {
				lookupTable.put(key, Math.max(
					findLRSMemoization(str, p1, p2 - 1, lookupTable), 
					findLRSMemoization(str, p1 - 1, p2, lookupTable)
				));
			}
		}

		// Returning value of the key from the Map
		return lookupTable.get(key);
	}

	// Driver code
	public static void main(String[] args) {
		ArrayList<String> inputs = new ArrayList<String>(
			Arrays.asList("abcd", "abddccd", "abbaba", "aaaaba", "abcdaeda")
		);

		// Let's uncomment this and check the effect of dynamic programming using memoization
		// inputs.add("abcdefghijklmnopqrstuv");

		for (int i = 0; i < inputs.size(); i++) {
      		System.out.println(i + 1 + ". String: " + inputs.get(i));
			System.out.println("Longest repeating subsequence is " + findLRS(inputs.get(i)));
			System.out.println(new String(new char[100]).replace('\0', '-') + '\n');
    	}
	}
}