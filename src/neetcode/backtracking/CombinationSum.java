package neetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//39. Combination Sum
//https://leetcode.com/problems/combination-sum/
public class CombinationSum {

  public static void main(String arg[]) {
    int arr[] = {2, 3, 6, 7};
    int target = 7;
    System.out.println(combinationSum(arr, target));
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new LinkedList<>();
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    sumUtils(candidates, target, result, new ArrayList<Integer>(), 0);
    return result;
  }

  private static void sumUtils(int[] candidates, int target, List<List<Integer>> result, List<Integer> curList,
      int index) {
    if (target == 0) {
      result.add(new ArrayList<>(curList));
      return;
    }
    if (target < 0) {
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      curList.add(candidates[i]);
      sumUtils(candidates, target - candidates[i], result, curList, i);
      curList.remove(curList.size() - 1);
    }
  }

}
