package neetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    //1046. Last Stone Weight
    //https://leetcode.com/problems/last-stone-weight/submissions/

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for (int i : stones) {
            q.offer(i);
        }

        while (q.size() > 1) {
            int data1 = q.poll();
            int data2 = q.poll();
            int diff = Math.abs(data1 - data2);
            if (diff != 0) {
                q.offer(diff);
            }
        }
        if (q.size() == 0) {
            return 0;
        } else {
            return q.peek();
        }
    }
}
