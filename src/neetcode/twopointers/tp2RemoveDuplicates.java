package patterns.TwoPointers;

import java.util.Arrays;

public class tp2RemoveDuplicates {

  public static void main(String args[]) {
    int arr[] = {2, 3, 3, 3, 6, 9, 9};
    System.out.println(removeDuplicates(arr));
  }

  public static int removeDuplicates(int arr[]) {
    int i = 1;
    int nextNonDupe = 1;
    while (i < arr.length) {
      int dupevalue = arr[nextNonDupe - 1];
      int othervalue = arr[i];
      if (arr[nextNonDupe - 1] != arr[i]) {
        arr[nextNonDupe] = arr[i];
        nextNonDupe++;
      }
      i++;
    }
    Arrays.stream(arr).forEach(x -> System.out.println(x));
    return nextNonDupe;
  }

}
