package educative.solution.grokkingcodinginterviewpatterns.modifiedbinarysearch;

import java.util.*;

public class BinarySearchRotated {

    // Driver code
    public static void main(String args[]) {
        List<List<Integer>> numList = Arrays.asList(
                Arrays.asList(5, 6, 7, 1, 2, 3, 4),
                Arrays.asList(40, 50, 60, 10, 20, 30),
                Arrays.asList(47, 58, 69, 72, 83, 94, 12, 24, 35),
                Arrays.asList(77, 82, 99, 105, 5, 13, 28, 41, 56, 63),
                Arrays.asList(48, 52, 57, 62, 68, 72, 5, 7, 12, 17, 21, 28, 33, 37, 41)
        );

        List<Integer> targetList = Arrays.asList(1, 50, 12, 56, 5);

        for (int i = 0; i < targetList.size(); i++) {
            System.out.println((i + 1) + ".\tSorted array: " + numList.get(i) +
                    "\n\ttarget " + targetList.get(i) + " found at index " +
                    binarySearchRotated(numList.get(i), targetList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int binarySearchRotated(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) == target)
                return mid;
            if (nums.get(start) <= nums.get(mid)) {
                if (nums.get(start) <= target && target < nums.get(mid)) {
                    end = mid - 1;
                } else
                    start = mid + 1;
            } else {
                if (nums.get(mid) < target && target <= nums.get(end))
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}