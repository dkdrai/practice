package educative.solution.grokkingcodinginterviewpatterns.twoheaps;

import java.util.PriorityQueue;

public class MedianDataStream {

    static PriorityQueue<Integer> maxHeapForSmallNumbers = new PriorityQueue<>((a, b) -> b - a);
    static PriorityQueue<Integer> minHeapForLargeNumbers = new PriorityQueue<>();

    public static void main(String[] args) {
        int[] nums = {35, 22, 30, 25, 1};
        for (int n : nums)
            System.out.println("median :" + median(n));
    }

    public static int median(int num) {
        if (maxHeapForSmallNumbers.isEmpty() || maxHeapForSmallNumbers.peek() >= num)
            maxHeapForSmallNumbers.offer(num);
        else
            minHeapForLargeNumbers.offer(num);

        if (minHeapForLargeNumbers.size() + 1 < maxHeapForSmallNumbers.size()) {
            minHeapForLargeNumbers.offer(maxHeapForSmallNumbers.poll());
        } else if (maxHeapForSmallNumbers.size() < minHeapForLargeNumbers.size()) {
            maxHeapForSmallNumbers.offer(minHeapForLargeNumbers.poll());
        }

        if (maxHeapForSmallNumbers.size() == minHeapForLargeNumbers.size()) {
            return (minHeapForLargeNumbers.peek() + maxHeapForSmallNumbers.peek()) / 2;
        } else {
            return maxHeapForSmallNumbers.peek();
        }
    }
}
