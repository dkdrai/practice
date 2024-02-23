package educative.solution.grokkingdp.recursivenumbers.dp;// Importing required functions
import java.util.*;

class Fib {
	static long getFibonacci(int n) {
		// Initializing the lookup table of size num + 1
		long [] lookupTable = new long[n + 1];
		Arrays.fill(lookupTable, -1); 
		return getFibonacciMem(n, lookupTable);
	}

	static long getFibonacciMem(int n, long[] lookupTable) {
		// Base case
		if (n < 2)
			return n;

		// Check if already present
		if (lookupTable[n] != -1)
			return lookupTable[n];

		// Adding entry to table if not present
		lookupTable[n] = getFibonacciMem(n - 1, lookupTable) + getFibonacciMem(n - 2, lookupTable);
		return lookupTable[n];
	}

	// Driver code
	public static void main(String[] args) {
		ArrayList<Integer> inputs = new ArrayList<Integer>(
			Arrays.asList(0, 5, 7, 10, 14)
		);

		 // Let's uncomment this and check the effect of dynamic programming using memoization
		 // inputs.add(60);

		for (int i = 0; i < inputs.size(); i++) {
			System.out.println(i + 1 + ". " + inputs.get(i) + "th Fibonacci number is: " + getFibonacci(inputs.get(i)));
			System.out.println(new String(new char[100]).replace('\0', '-') + '\n');
    	}
	}
}