package educative.solution.grokkingdp.recursivenumbers.dp;// Importing required functions
import java.util.*;

class GameScoring {
	private static long scoringOptionsRec(int n, long[] memo) {
		// We can not get a negative score, we return 0 for negative values
    	if (n < 0) return 0;

		// Check if a solution already exists in the array
		if (memo[n] != -1) return memo[n];

		// Else, we recursively calculate the solution for the
		// given value and store it in our solution array
		return memo[n] =
				scoringOptionsRec(n - 1, memo) + scoringOptionsRec(n - 2, memo) + scoringOptionsRec(n - 4, memo);
	}

	// Scoring options are 1, 2, and 4
	public static long scoringOptions(int n) {
		// Initializing our solution array
		long[] memo = new long[n + 1];
		Arrays.fill(memo, -1);

		// Set up the base case, 1 way to score 0
		memo[0] = 1;

		// Pass our array to the helper function
		return scoringOptionsRec(n, memo);
	}

	// Driver code
	public static void main(String[] args) {
		int[] totalScores = {3, 5, 10, 25, 0};

		// You can uncomment the lines below and check how this top-down solution executes without a time-out
		
		// totalScores = Arrays.copyOf(totalScores, totalScores.length + 1);
        // totalScores[totalScores.length - 1] = 50;

		for (int i = 0; i < totalScores.length; i++) {
			System.out.println((i + 1) + ".\tn: " + totalScores[i] + 
			"\n\n\tNumber of ways to reach the score: " + scoringOptions(totalScores[i]));
			System.out.println(new String(new char[100]).replace('\0', '-'));
		}
	}
}