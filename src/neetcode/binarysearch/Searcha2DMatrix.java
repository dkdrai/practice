package neetcode.binarysearch;

public class Searcha2DMatrix {

  //74. Search a 2D Matrix
  //https://leetcode.com/problems/search-a-2d-matrix/

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }
    int row = matrix.length;
    int column = matrix[0].length;
    for (int i = 0; i < row; i++) {
      if (matrix[i][0] <= target && matrix[i][column - 1] >= target) {
        int left = 0;
        int right = column - 1;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          if (matrix[i][mid] == target) {
            return true;
          } else if (matrix[i][mid] < target) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
      }
    }
    return false;
  }

}
