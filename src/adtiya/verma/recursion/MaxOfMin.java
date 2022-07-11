package adtiya.verma.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

class MaxOfMin {


  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 1, 2};
    int arr1[] = {10, 20, 30, 40, 25, 81, 98, 45};
    int[] sol1 = maxSlidingWindow(arr, 1);
    int min = IntStream.range(0, sol1.length)
        .map(i -> sol1[i])
        .min()
        .getAsInt();
    System.out.println(min);
    System.out.println("solution");
    int[] sol2 = maxSlidingWindow(arr1, 8);
      int min2 = IntStream.range(0, sol2.length)
          .map(i -> sol2[i])
          .min()
          .getAsInt();
      System.out.println(min2);

  }


  public static int[] maxSlidingWindow(int[] nums, int k) {
      if (nums.length == 1) {
          return nums;
      }
    Deque<Integer> deq = new ArrayDeque<>();
    int N = nums.length;
    List<Integer> res = new ArrayList<>();

    for (int l = 0, r = 0; r < N; r++) {
      while (!deq.isEmpty() && nums[deq.getLast()] < nums[r]) {
        deq.removeLast();
      }
      deq.addLast(r);
      if (r - l + 1 == k) {
        res.add(nums[deq.getFirst()]);
          if (deq.getFirst() == l) {
              deq.removeFirst();
          }
        l++;
      }
    }
    int[] ans = res.stream().mapToInt(i -> i).toArray();
    return ans;
  }

}