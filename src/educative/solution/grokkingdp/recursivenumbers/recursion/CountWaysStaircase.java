package educative.solution.grokkingdp.recursivenumbers.recursion;// Importing required functions

public class CountWaysStaircase {

    // O(3^n)
	public static long countWays(int n) {
        // Base Conditions
    if (n < 0)
      return 0;

    else if(n == 0)
      return 1;

    // Check each possible combination
    else
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
	}

	public static void main(String[] args) {
		int[] inputs = {0, 4, 3, 5, 6};

    // You can uncomment the lines below and check how this recursive solution causes a time-out
    // int temp[] = Arrays.copyOf(inputs, inputs.length + 1);
    // temp[inputs.length] = 39;
    // inputs = temp;    
      
    for (int i = 0; i < inputs.length; i++) {
        System.out.println((i + 1) + ".\tSteps: " + inputs[i] + 
                                     "\n\n\tNumber of ways: " + countWays(inputs[i])); 			

        System.out.println(new String(new char[100]).replace('\0', '-'));		
		}
	}
}