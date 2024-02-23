package educative.solution.grokkingdp.recursivenumbers.dp;// Importing required functions

public  class CountWaysStaircase {
	public static long countWaysRec(int n, long[] lookupArray) {
    // Negative staircases i.e., invalid input
    if (n < 0)
      return 0;

    // If 0 staircases
    else if (n == 0)
      return 1;
  
    //If already present in the table
    else if (lookupArray[n] > -1) 
        return lookupArray[n];

    // If not present in the table
    else
        lookupArray[n] = countWaysRec(n - 1, lookupArray)+ countWaysRec(n - 2, lookupArray)+ countWaysRec(n - 3, lookupArray);

    return lookupArray[n];

	}

  public static long countWays(int n) {
    long lookupArray[] = new long[n + 1];
    for(int i = 0; i < lookupArray.length; i++) {
        lookupArray[i] = -1;
    }
    return countWaysRec(n, lookupArray);

  }

  // Driver code
	public static void main(String[] args) {
		int[] inputs = {0, 4, 3, 5, 6};

    // Let's uncomment this and check the effect of dynamic programming using memoization
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