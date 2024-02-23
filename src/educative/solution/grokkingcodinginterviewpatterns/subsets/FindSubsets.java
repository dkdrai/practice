package educative.solution.grokkingcodinginterviewpatterns.subsets;

import java.util.*;

class FindSubsets {

    public static void main(String[] args) {
        int arr[] = {1, 2,3};
        System.out.println(findAllSubsets(arr));
    }

    public static List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();
        subset(nums, 0, setsList, new ArrayList<>());
        return setsList;
    }

    public static void subset(int[] nums, int i, List<List<Integer>> result, List<Integer> list) {
        if (i == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        subset(nums, i + 1, result, list);
        list.add(nums[i]);
        subset(nums, i + 1, result, list);
        list.remove(list.size() - 1);

    }
}