package neetcode.arrayandhashing;

public class TwoSumSortedArray {

  //167. Two Sum II - Input Array Is Sorted
  //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
  public int[] twoSum(int[] numbers, int target) {
    int sol[] = new int[2];
    if (numbers == null || numbers.length == 0) {
      return null;
    }
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target) {
        sol[0] = left + 1;
        sol[1] = right + 1;
        return sol;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }

    }
    return sol;
  }

}
