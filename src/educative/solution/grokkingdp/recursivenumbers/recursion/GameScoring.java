package educative.solution.grokkingdp.recursivenumbers.recursion;// Importing required functions

class GameScoring {
	// Scoring options are 1, 2, and 4
	public static long scoringOptions(int n) {
		// Setting up our base cases
		
		// We can not get a negative score, we return 0 for negative values
		if (n < 0) return 0;

		// There is only 1 way to reach a score of 0
		if (n == 0) return 1;

		// Recursively calculate the number of ways using the
		// recurrence relation we saw earlier
		return scoringOptions(n - 1) + scoringOptions(n - 2) + scoringOptions(n - 4);
	}

	// Driver code
	public static void main(String[] args) {
		int[] totalScores = {3, 5, 10, 25, 0};

		// You can uncomment the lines below and check how this recursive solution causes a time-out
		
		// totalScores = Arrays.copyOf(totalScores, totalScores.length + 1);
        // totalScores[totalScores.length - 1] = 50;

		for (int i = 0; i < totalScores.length; i++) {
			System.out.println((i + 1) + ".\tn: " + totalScores[i] + 
			"\n\n\tNumber of ways to reach the score: " + scoringOptions(totalScores[i]));
			System.out.println(new String(new char[100]).replace('\0', '-'));
		}
	}
}