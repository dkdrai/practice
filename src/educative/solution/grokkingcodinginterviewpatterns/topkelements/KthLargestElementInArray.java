package educative.solution.grokkingcodinginterviewpatterns.topkelements;

import java.util.*;


public class KthLargestElementInArray{
  public static int findKthLargest(int[] nums, int k){    
    PriorityQueue<Integer> kNumbersMinHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

    for (int i = 0; i < k; i++) {
      kNumbersMinHeap.add(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {
      if (nums[i] > kNumbersMinHeap.peek()) {
        kNumbersMinHeap.poll();
        kNumbersMinHeap.add(nums[i]);
      }
    }

    return kNumbersMinHeap.peek();
  }


  // Driver code
  public static void main(String[] args) {
    int[][] inputs = {
                    {1, 5, 12, 2, 11, 9, 7, 30, 20},
                    {5, 2, 9, -3, 7},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 4, 6, 0, 2},
                    {3, 5, 2, 3, 8, 5, 3}
                };

    int[] K = {3, 1, 9, 1, 4};
    
    for(int i=0; i<K.length; i++){
      System.out.print(i+1);
      System.out.println(".\tInput array: "+ Arrays.toString(inputs[i]));
      System.out.println("\tValue of k: "+ K[i]);
      System.out.println("\tkth largest element: " + findKthLargest(inputs[i], K[i]));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}