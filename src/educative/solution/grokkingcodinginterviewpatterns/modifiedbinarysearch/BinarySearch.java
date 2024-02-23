package educative.solution.grokkingcodinginterviewpatterns.modifiedbinarysearch;

public class BinarySearch {


    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int ar[] = {11, 22, 33, 44, 55, 66, 77};
        int target = 33;
        System.out.println(binarySearch(ar, target));
    }
}