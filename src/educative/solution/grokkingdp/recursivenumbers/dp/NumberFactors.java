package educative.solution.grokkingdp.recursivenumbers.dp;// Importing required functions
import java.util.*;
import java.util.stream.*;

class NumberFactors {
	private static long countWaysRec(int n, long[] memo) {
		// Setting up our base cases
		// We can not get a negative target number at any point, 
		// so we return 0 for negative values
    	if(n < 0) return 0;

		// Check if a solution already exists in the array
		if (memo[n] != -1)
			return memo[n];

		// Else, we recursively calculate the solution for the
		// given value and store it in our solution array
		return memo[n] =
				countWaysRec(n - 1, memo) + countWaysRec(n - 3, memo) + countWaysRec(n - 4, memo);
	}

	// Available numbers are 1, 3, and 4
	public static long countWays(int n) {
		// Initializing our solution array
		long[] memo = new long[n + 1];
		Arrays.fill(memo, -1);

		// Set up the base case, 1 way to get to the number 0
		memo[0] = 1;

		// Pass our array to the helper function
		return countWaysRec(n, memo);
	}

	public static void main(String[] args) {
		int[] targetNumbers = {3, 5, 10, 25, 0};

        // You can uncomment the lines below and check how this top-down solution executes without a time-out 
		
		// targetNumbers = Arrays.copyOf(targetNumbers, targetNumbers.length + 1);
        // targetNumbers[targetNumbers.length - 1] = 50;

		for (int i = 0; i<targetNumbers.length; i++) {
			System.out.println(i + 1 + ".\tn: " + targetNumbers[i] +
									   "\n\n\tNumber of ways to reach the target number: " + countWays(targetNumbers[i]));

			Stream.generate(() -> "-").limit(100).forEach(System.out::print);
			System.out.println(" ");
		}
	}
}