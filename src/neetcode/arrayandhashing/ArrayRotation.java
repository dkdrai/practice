package neetcode.arrayandhashing;

import java.util.Arrays;

public class ArrayRotation {

  public static void main(String ar[]) {
    int arr[] = {1, 2, 3, 4, 5};
    System.out.println("pre rotations");
    Arrays.stream(arr).forEach(x -> System.out.println(x));
    // arr = rotateWithTemp(arr, 2, 5);
    rotateWithMove(arr, 2, 5);
    System.out.println("after rotations");
    Arrays.stream(arr).forEach(x -> System.out.println(x));
  }

  public static int[] rotateWithTemp(int arr[], int d, int n) {
    int tempArra[] = new int[arr.length];
    int k = 0;
    for (int i = d; i < arr.length; i++) {
      tempArra[k] = arr[i];
      k++;
    }
    for (int i = 0; i < d; i++) {
      tempArra[k] = arr[i];
      k++;
    }
    return tempArra;
  }

  public static int[] rotateWithMove(int arr[], int d, int n) {
    for (int i = 0; i < d; i++) {
      moveElementByOnePosition(arr);
    }
    return arr;
  }

  public static void moveElementByOnePosition(int arr[]) {
    int temp = arr[0];
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = temp;
  }

}
