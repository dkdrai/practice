package neetcode.slidingwindow;
public class sw1MaxSumSubarrayofsizeK {

  public static void main(String args[]) {
    int arr[] = {3, 5, 2, 1, 7, 8};
    System.out.println(maximumSumSubarrayBrute(2, arr));
    System.out.println(maximumSumSubarraySlide(2, arr));
    System.out.println(getMax(arr, 2));
  }

  static int maximumSumSubarraySlide(int k, int arr[]) {
    int max = 0;
    int current = 0;
    int left = 0;
    for (int i = 0; i < arr.length; i++) {
      current = current + arr[i];
      if ((i - left + 1) == k) {
        max = Math.max(max, current);
        current = current - arr[left];
        left++;
      }
    }
    return max;
  }

  static int maximumSumSubarrayBrute(int K, int arr[]) {
    int count = 0;
    int max = 0;
    for (int i = 0; i <= arr.length - K; i++) {
      int newMax = 0;
      for (int k = i; k < i + K; k++) {
        newMax = newMax + arr[k];
        count++;
      }
      if (newMax > max) {
        max = newMax;
      }
    }
    System.out.println("count" + count);
    return max;
  }

  public static int getMax(int arr[], int k) {
    int left = 0, max = 0, currentMax = 0;
    if (k > arr.length) {
      return 0;
    }
    for (int i = 0; i < arr.length; i++) {
      currentMax += arr[i];
      if (k == (i - left + 1)) {
        max = Math.max(currentMax, max);
        currentMax -= arr[left];
        left++;
      }
    }
    return max;
  }

}
