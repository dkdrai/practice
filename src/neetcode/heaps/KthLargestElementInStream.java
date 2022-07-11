package neetcode.heaps;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    public static void main(String arg[]) {
        int arr[] = {4, 5, 8, 2};
        KthLargestElementInStream heap = new KthLargestElementInStream(3, arr);
        System.out.println("init " + heap.q);
        System.out.println(heap.add(3));
        System.out.println(heap.add(5));
        System.out.println(heap.add(10));
        System.out.println(heap.add(9));
        System.out.println(heap.add(4));
    }

    //703. Kth Largest Element in a Stream
    //https://leetcode.com/problems/kth-largest-element-in-a-stream/
    //https://www.youtube.com/watch?v=hOjcdrqMoQ8&t=16
    final PriorityQueue<Integer> q;
    final int k;

    public KthLargestElementInStream(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a) {
            add(n);
        }
    }

    public int add(int n) {
        if (q.size() < k) {
            q.add(n);
        } else if (q.peek() < n) {
            q.poll();
            q.add(n);
        }
        return q.peek();
    }

}
