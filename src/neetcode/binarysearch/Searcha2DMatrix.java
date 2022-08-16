package neetcode.binarysearch;

import java.util.Arrays;

public class Searcha2DMatrix {

    //240. Search a 2D Matrix II
    //https://leetcode.com/problems/search-a-2d-matrix-ii/

    public static void main(String args[]) {
        int[][] mat = {{35, 45, 55, 65},
                {40, 50, 60, 70},
                {52, 54, 62, 73},
                {57, 58, 64, 75}};
        int result[] = searchMatrix(mat, 64);
        Arrays.stream(result).forEach(x -> System.out.print(x));
    }

    public static int[] searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0;
        int j = column - 1;
        while (i >= 0 && i < row && j >= 0 && j < column) {
            if (matrix[i][j] == target) {
                return new int[]{i, j};
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

}
