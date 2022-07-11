package neetcode.twopointers;

import java.util.Arrays;

public class tp7DutchNationalFlagProblem {

  public static void main(String args[]) {
    int arr[] = {2, 2, 2, 0, 2, 1, 1, 0};
    dutchFlag(arr);
  }

  public static void dutchFlag(int arr[]) {
    int left = 0;
    int right = arr.length - 1;
    int i = 0;
    while (i <= right) {
      int temp;
      if (arr[i] == 0) {
        temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;
        i++;
        left++;
      } else if (arr[i] == 1) {
        i++;
      } else {
        temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        right--;
      }
    }
    Arrays.stream(arr).forEach(x -> System.out.println(x));
  }

  public static int[] solve(int arr[]) {
    int low = 0;
    int high = arr.length - 1;
    int i = 0;
    while (i <= high) {
      int temp;
      if (arr[i] == 0) {
        temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
        i++;
        low++;
      } else if (arr[i] == 1) {
        i++;
      } else {
        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        high--;
      }
    }
    Arrays.stream(arr).forEach(x -> System.out.println(x));
    return arr;
  }
}
