package patterns.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]*/
public class tp1TwoSum {

  public static void main(String args[]) {
    int arr[] = {2, 7, 11, 15, 10, 20, 30};
    int solu[] = solution(arr, 41);
    Arrays.stream(solu).forEach(x -> System.out.println(x));
  }

  //Input: nums = [2,7,11,15], target = 9
  public static int[] solution(int arr[], int target) {
    int sol[] = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int complement = target - arr[i];
      if (map.containsKey(complement)) {
        sol[0] = map.get(complement);
        sol[1] = i;
        return sol;
      } else {
        map.put(arr[i], i);
      }
    }
    return new int[2];
  }
}
