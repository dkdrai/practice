package neetcode.intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String args[]) {
        //int arr[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int arr[][] = {{1, 4}, {4, 5}};
        Arrays.stream(arr).forEach(x -> Arrays.stream(x).forEach(y -> System.out.print(y)));

        System.out.println("solution");
        int res[][] = merge(arr);
        Arrays.stream(res).forEach(x -> Arrays.stream(x).forEach(y -> System.out.print(y)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}