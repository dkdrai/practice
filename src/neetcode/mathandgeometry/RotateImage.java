package neetcode.mathandgeometry;

import javax.imageio.ImageTranscoder;

//48. Rotate Image
//https://leetcode.com/problems/rotate-image/
public class RotateImage {

  public static void main(String ar[]) {
    int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    display(arr);
    rotate(arr);
    display(arr);
  }

  public static void display(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(" " + matrix[i][j]);
      }
      System.out.println("");
    }
  }

  public static void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[i].length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      int left = 0;
      int right = matrix[i].length - 1;
      while (left < right) {
        int temp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = temp;
        left++;
        right--;
      }
    }

  }
}
