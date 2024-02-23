package educative.solution.grokkingdp.recursivenumbers.recursion;

import java.util.*;

class Tribonacci{

	//The time complexity of the naive approach is
	//�
	//(
	//2
	//�
	//)
	//O(2
	//n
	// )
	//. Note that although at first glance time complexity seems to be O(3 ^n)
	//, it can be proven that O(2^n)
	// is a tighter upper bound.
	public static long tribonacci(int n){
		// base cases
		if (n < 3)
			return n == 0 ? 0 : 1;	
		// recursive case
		return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
	}

	public static void main(String[] args){
		ArrayList<Integer> n = new ArrayList<Integer>(
            Arrays.asList(4, 5, 25, 17, 19)
        );
		
		// You can uncomment the lines below and check how this recursive solution causes a time-out

    	// n.add(45);
		
		int index = 0;
		for (int input : n) {
			System.out.println((++index)+ ".\tThe "+ input+ "th Tribonacci number is:  "
					+ tribonacci(input));
			System.out.println(new String(new char[100]).replace('\0', '-'));
		}
	}
}