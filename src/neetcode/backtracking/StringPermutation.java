package neetcode.backtracking;

public class StringPermutation {

  public static void main(String ar[]) {
    String arr[] = {"A", "B", "C"};
    permute(arr, 0);
  }

  private static void permute(String arr[], int n) {
    if (n == arr.length) {
      for (String c : arr) {
        System.out.print(c + " ");
      }
      System.out.println("");
      return;
    }
    for (int i = n; i < arr.length; i++) {
      String temp = arr[n];
      arr[n] = arr[i];
      arr[i] = temp;
      permute(arr, n + 1);
      temp = arr[n];
      arr[n] = arr[i];
      arr[i] = temp;
    }
  }
}
