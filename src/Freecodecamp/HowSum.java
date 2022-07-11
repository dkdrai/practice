package Freecodecamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {


    public static Map<Integer, Boolean> solution = new HashMap<>();

    public static void main(String arg[]) {
        int arr[] = {5, 7, 4, 8};
        System.out.println(canSum(6, arr, 0, new ArrayList<Integer>()));
        System.out.println(canSumMemo(6, arr, 0, new ArrayList<Integer>()));
    }

    public static List<Integer> canSum(int target, int arr[], int i, List result) {
        if (target == 0) {
            return result;
        }
        if (i == arr.length) {
            return null;
        }
        if (arr[i] <= target) {
            return canSum(target - arr[i], arr, i, result) ;
        } else {
            return canSum(target, arr, i + 1, result);
        }
    }

    public static boolean canSumMemo(int target, int arr[], int i, List result) {
        if (solution.containsKey(target)) {
            return solution.get(target);
        }
        if (target == 0) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }

        return solution.get(target);
    }

}
