package neetcode.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KFrequentElements {


  public static void main(String ar[]) {
    int nums[] = {1,1,1,2,2,3};
    for (int i : topKFrequentHeap(nums, 2)) {
      System.out.println(i);
    }
  }


  //347. Top K Frequent Elements
  //https://leetcode.com/problems/top-k-frequent-elements/
  // use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
  public static int[] topKFrequentHeap(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k == 0 || nums.length < k) {
      return new int[0];
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
        new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      maxHeap.add(entry);
    }

    System.out.println(maxHeap);
    List<Integer> res = new ArrayList<>();
    while (res.size() < k) {
      Map.Entry<Integer, Integer> entry = maxHeap.poll();
      res.add(entry.getKey());
    }
    return res.stream().mapToInt(i -> i).toArray();
  }

}
