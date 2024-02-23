package educative.solution.grokkingdp.recursivenumbers.recursion;// Importing required functions
import java.util.stream.*;

class NumberFactors {

	//O(2^n)
	// Available numbers are 1, 3, and 4
	public static long countWays(int n) {
		// Setting up our base cases
		
		// We can not get a negative target number at any point, 
    	// so we return 0 for negative values
		if (n < 0) return 0;

		// There is only 1 way to reach a target number of 0, 
    	// by not using any available numbers
		if (n == 0) return 1;

		// Recursively calculate the number of ways using the
		// recurrence relation we saw earlier
		return countWays(n - 1) + countWays(n - 3) + countWays(n - 4);
	}

	public static void main(String[] args) {
		int[] targetNumbers = {3, 5, 10, 25, 0};

		// You can uncomment the lines below and check how this recursive solution causes a time-out
		
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