package neetcode.mathandgeometry;

import java.util.ArrayList;
import java.util.List;

//54. Spiral Matrix
//https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {

  public static void main(String ar[]) {
    int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    System.out.println(spiralOrder(arr));
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int rowBeg = 0;
    int rowEnd = matrix.length - 1;
    int colBeg = 0;
    int colEnd = matrix[0].length - 1;
    while (rowBeg <= rowEnd && colBeg <= colEnd) {
      for (int i = colBeg; i <= colEnd; i++) {
        result.add(matrix[rowBeg][i]);
      }
      rowBeg++;
      for (int i = rowBeg; i <= rowEnd; i++) {
        result.add(matrix[i][colEnd]);
      }
      colEnd--;
      if (rowBeg <= rowEnd) {
        for (int i = colEnd; i >= colBeg; i--) {
          result.add(matrix[rowEnd][i]);
        }

      }
      rowEnd--;
      if (colBeg <= colEnd) {
        for (int i = rowEnd; i > rowBeg; i--) {
          result.add(matrix[i][colBeg]);
        }

      }
      colBeg++;
    }
    return result;
  }
}
