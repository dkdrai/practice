package educative.solution.grokkingdp.recursivenumbers.recursion;// Importing required functions

class UniquePaths {


	// O(2^ m*n)
	// Helper function to check the boundaries and base case
	public static int findUniquePathRecursive(int i, int j, int rows, int cols, int[][] matrix) {
		// check the boundary constraints
		if (i == rows || j == cols){
			return 0;
		}
		
		// check if obastacle is present or not
		if (matrix[i][j] == 1){
			return 0;
		}

		// check the base case when the last cell is reached
		if (i == rows-1 && j == cols-1){
			return 1;
		}
		
		// using the recursive appraoch when moving to next row or next column 
		return findUniquePathRecursive(i+1, j, rows, cols, matrix) + findUniquePathRecursive(i, j+1, rows, cols, matrix);
	}
	
	public static int findUniquePath(int[][] matrix) {
		
		// the length of 2d matrix will be equal to the number of rows
		int rows = matrix.length;

		// The number of elements in 1st row are equal to the number of columns in 2d matrix
		int cols = matrix[0].length;
		
		return findUniquePathRecursive(0, 0, rows, cols, matrix);
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
		
		// You can uncomment the lines below and check how this recursive solution causes a time-out 

		// int newArr[][][] = Arrays.copyOf(inputs, inputs.length + 1);
		// newArr[inputs.length] = new int[][]{{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		// inputs = newArr;

		String printedOutput = ""; 
		for (int i = 0; i < inputs.length; i++) {
			int paths = findUniquePath(inputs[i]);
			System.out.println(printedOutput + paths);
			System.out.println(new String(new char[100]).replace('\0', '-'));		}
	}
}