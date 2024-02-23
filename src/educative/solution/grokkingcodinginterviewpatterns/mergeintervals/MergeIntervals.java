package educative.solution.grokkingcodinginterviewpatterns.mergeintervals;

import java.util.*;

/*
* Solution summary
To recap, the solution to this problem can be divided into the following two parts:

Insert the first interval from the input list into the output list.

Traverse the input list of intervals. For each interval in the input list, we do the following:

If the input interval is overlapping with the last interval in the output list, merge these two intervals and replace the last interval of the output list with this merged interval.
Otherwise, add the input interval to the output list.*/
public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            return result.toArray(new int[][]{});
        }

        result.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            int[] lastAddedInterval = result.get(result.size() - 1);
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int prevEnd = lastAddedInterval[1];

            if (currStart <= prevEnd) {
                result.get(result.size() - 1)[1] = Math.max(currEnd, prevEnd);
            } else {
                result.add(new int[]{currStart, currEnd});
            }
        }

        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][][] allIntervals = {
            {{1, 5}, {3, 7}, {4, 6}},
            {{1, 5}, {4, 6}, {6, 8}, {11, 15}},
            {{3, 7}, {6, 8}, {10, 12}, {11, 15}},
            {{1, 5}},
            {{1, 9}, {3, 8}, {4, 4}},
            {{1, 2}, {3, 4}, {8, 8}},
            {{1, 5}, {1, 3}},
            {{1, 5}, {6, 9}},
            {{0, 0}, {1, 18}, {1, 3}}
        };

        for (int i = 0; i < allIntervals.length; i++) {
            System.out.println(i + 1 + ".\tIntervals to merge: " + Arrays.deepToString(allIntervals[i]));
            int[][] result = mergeIntervals(allIntervals[i]);
            System.out.println("\tMerged intervals: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}