package neetcode.heaps;

import java.util.PriorityQueue;

//215. Kth Largest Element in an Array
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementinanArray {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    if(nums == null || nums.length ==0){
      return -1;
    }
    for(int i : nums){
      heap.add(i);
      if(heap.size()>k){
        heap.remove();
      }
    }

    return heap.remove();
  }

}
