package neetcode.binarysearch;

import java.util.Arrays;

public class CocoEatingBanana {

  public static void main(String ar[]) {
    int arr[] = {30,11,23,4,20};
    System.out.println(minEatingSpeed(arr, 6));
  }

  //875. Koko Eating Bananas
  //https://leetcode.com/problems/koko-eating-bananas/
  public static int minEatingSpeed(int[] piles, int h) {
    int l = 1, r =  Arrays.stream(piles).max().getAsInt();;
    while (l < r) {
      int m = (l + r) / 2, total = 0;
      for (int p : piles) {
        total += (p + m - 1) / m;
        System.out.println((p + m - 1) / m);
      }
      if (total > h)
        l = m + 1;
      else
        r = m;
    }
    return l;
  }



}
