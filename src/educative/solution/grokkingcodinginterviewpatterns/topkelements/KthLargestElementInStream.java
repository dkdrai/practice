package educative.solution.grokkingcodinginterviewpatterns.topkelements;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    // constructor to initialize topKHeap and add values in it
    PriorityQueue<Integer> queue;
    int size;

    public KthLargestElementInStream(int k, int[] nums) {
        queue = new PriorityQueue<>();
        size = k;
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > size) {
                queue.poll();
            }
        }
    }

    // adds element in the topKHeap
    public int add(int val) {
        // Replace this placeholder return statement with your code
        if (queue.size() >= size) {
            if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        KthLargestElementInStream stream = new KthLargestElementInStream(5, arr);
        System.out.println(stream.add(6));
        System.out.println(stream.add(7));
        System.out.println(stream.add(1));
    }
}