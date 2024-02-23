package educative.solution.grokkingcodinginterviewpatterns.mergeintervals;

import java.util.*;

public class insertInterval {
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        // Read the starting and ending time of the new interval into separate variables
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        System.out.println("The new interval starts at " + newStart + " and ends at " + newEnd + ".");
        
        // Initialize variables to help in iterating over the existing intervals array
        int i = 0;
        int n = existingIntervals.length;
        System.out.println("There are " + n + " intervals present in the list already. We append the intervals that have the starting point smaller than our new interval to add.");
        
        // Initialize a list to store the output temporarily
        List<int[]> outputList = new ArrayList<>();
        
        // Append all intervals that start before the new interval to the output list
        while (i < n && existingIntervals[i][0] < newStart) {
            outputList.add(existingIntervals[i]);
            i += 1;
        }
        
        System.out.println("The output before we add the new interval is: " + Arrays.deepToString(outputList.toArray()));
        
        // If the new interval starts after the end of the last interval appended to the output list,
        // just append the new interval to the output list.
        if (outputList.size() == 0 || outputList.get(outputList.size() - 1)[1] < newStart) {
            outputList.add(newInterval);
        } else {
            // Otherwise, merge the two intervals
            outputList.get(outputList.size() - 1)[1] = Math.max(outputList.get(outputList.size() - 1)[1], newEnd);
        }
        
        // Copy any remaining intervals to the output list,
        // similarly merging any overlapping intervals as we go
        while (i < n) {
            int[] existingInterval = existingIntervals[i];
            int start = existingInterval[0];
            int end = existingInterval[1];
            if (outputList.get(outputList.size() - 1)[1] < start) {
                outputList.add(existingInterval);
            } else {
                outputList.get(outputList.size() - 1)[1] = Math.max(outputList.get(outputList.size() - 1)[1], end);
            }
            i += 1;
        }
        
        // Convert the list back to a 2D array
        int[][] outputArray = outputList.toArray(new int[0][0]);
        
        System.out.println("The output after we add the new interval and merge the overlapping intervals is: " + Arrays.deepToString(outputList.toArray()));
        return outputArray;
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.println("Existing intervals: " + Arrays.deepToString(existingIntervals[i]));
            System.out.println("New interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}