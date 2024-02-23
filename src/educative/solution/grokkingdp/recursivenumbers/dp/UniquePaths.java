package educative.solution.grokkingdp.recursivenumbers.dp;// Importing required functions
import java.util.*;

class UniquePaths {

	// Helper function to check the boundaries and base case
  	public static int findUniquePathMemoization(int i, int j, int rows, int cols, int[][] matrix, int [][] pathArray) {
	  
		// check the boundary constraints
		if (i == rows || j == cols){
		return 0;
		}

		// check if obstacle is present or not 
		if (matrix[i][j] == 1){
		return 0;
		}

		// check the base case when the last cell is reached
		if (i == rows-1 && j == cols-1)
		{
		return 1;
		}

		if (pathArray[i][j] != -1){
			return pathArray[i][j];
		}

		pathArray[i][j] = findUniquePathMemoization(i+1, j, rows, cols, matrix, pathArray) + findUniquePathMemoization(i, j+1, rows, cols, matrix, pathArray);
		
		return pathArray[i][j];
	}

	public static int findUniquePath(int[][] matrix) {

		// the length of 2d matrix will be equal to the number of rows
		int rows = matrix.length;

		// The number of elements in 1st row are equal to the number of columns in 2d matrix
    	int cols = matrix[0].length;
    	
		int[][] pathArray = new int[rows][cols];
		for (int[] row: pathArray){
			Arrays.fill(row, -1);
		}

		return findUniquePathMemoization(0, 0, rows, cols, matrix, pathArray);
	}
	
	// Driver code
	public static void main(String[] args) {
		int[][][] inputs = {
			{{0,1}, {0,0}},
			{{0,0,0}, {0,0,0}, {0,0,0}},
			{{0,0,0}, {0,1,0}, {0,0,0}},
			{{0,0,0}, {1,1,1}, {0,0,0}},
			{{0,0,0,0},{1,0,1,0},{1,0,0,0},{0,1,0,0}}
		};
		
		// Let's uncomment this and check the effect of dynamic programming using memoization

		// int newArr[][][] = Arrays.copyOf(inputs, inputs.length + 1);
		// newArr[inputs.length] = new int[][]{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		// inputs = newArr;

		String printedOutput = ""; 
		for (int i = 0; i < inputs.length; i++) {
			int paths = findUniquePath(inputs[i]);
			System.out.println(printedOutput + paths);
			System.out.println(new String(new char[100]).replace('\0', '-'));
		}

	}
}