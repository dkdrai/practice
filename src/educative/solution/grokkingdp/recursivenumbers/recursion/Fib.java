package educative.solution.grokkingdp.recursivenumbers.recursion;// Importing required functions
import java.util.*;

class Fib {
	static long getFibonacci(int n) {
		// Base case for n = 0 and n = 1
		if (n < 2) {
			return n;
		}

		// Otherwise, calculate the Fibonacci number using the recurrence relation
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}

	// Driver code
	public static void main(String[] args) {
		ArrayList<Integer> inputs = new ArrayList<Integer>(
			Arrays.asList(0, 5, 7, 10, 14)
		);

		// You can uncomment the line below and check how this recursive solution causes a time-out 
   		// inputs.add(60);

		for (int i = 0; i < inputs.size(); i++) {
			System.out.println(i + 1 + ". " + inputs.get(i) + "th Fibonacci number is: " + getFibonacci(inputs.get(i)));
			System.out.println(new String(new char[100]).replace('\0', '-') + '\n');
    	}
	}
}