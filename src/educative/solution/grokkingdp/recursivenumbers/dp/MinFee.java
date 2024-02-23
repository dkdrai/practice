package educative.solution.grokkingdp.recursivenumbers.dp;// Importing required functions
import java.util.*;

class MinFee {
	public static int minFeeRec(int [] fee,int n, int [] lookupArray) {
    // Base Conditions
    if (n < 1)
      return 0;

    // Check if the minimum fee is present in the array
    else if(lookupArray[n]>-1)
      return lookupArray[n];
    
    else{
      //Finding the fee for each step and then storing the minimum in the array
      int oneStep = fee[n - 1] + minFeeRec(fee, n - 1, lookupArray);
      int twoStep = n - 2 >= 0 ? fee[n - 2] + minFeeRec(fee, n - 2, lookupArray) : fee[n - 2 + fee.length] + minFeeRec(fee, n - 2, lookupArray);
      int threeStep = n - 3 >= 0 ? fee[n - 3] + minFeeRec(fee, n - 3, lookupArray) : fee[n - 3 + fee.length] + minFeeRec(fee, n - 3, lookupArray);
      lookupArray[n] = Math.min(Math.min(oneStep, twoStep), threeStep);
    }
    return lookupArray[n];
	}

  public static int minFee(int [] fee,int n) {
    int lookupTable[] = new int[n + 1];
    for(int i = 0; i < lookupTable.length; i++) {
        lookupTable[i]= -1;
    }
    return minFeeRec(fee,n, lookupTable);

  }
  
  // Driver code
  public static void main(String[] args) {
    int[][] inputs = {{1, 2, 5, 2, 1, 2}, {2, 3, 4, 5}, 
                      {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 
                      {10, 15, 20}, {0, 1, 2, 3, 4, 5, 6, 7, 8}};

    // Let's uncomment this and check the effect of dynamic programming using memoization
    // int[][] temp = Arrays.copyOf(inputs, inputs.length + 1);
    // temp[inputs.length] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
    //                                 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 
    //                                 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 
    //                                 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 
    //                                 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 
    //                                 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 
    //                                 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 
    //                                 94, 95, 96, 97, 98, 99};
    // inputs = temp;
    
    String printedOutput = ""; 
    for (int i = 0; i < inputs.length; i++) {
        printedOutput = (i + 1) + ".\tSteps: " + inputs[i].length + "\n\tFee: " + Arrays.toString(inputs[i]) + "\n\n\t";

        int minimumFee = minFee(inputs[i],inputs[i].length);
                System.out.println(printedOutput + "Minimum fee: " + minimumFee);
        System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}