package Freecodecamp;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    static boolean result[];
    static int sumCount = 0;
    static int recCOunt = 0;
    public static Map<Integer, Boolean> solution = new HashMap<>();

    public static void main(String arg[]) {
        int arr[] = {5, 7, 4, 8};

        result = new boolean[arr.length + 1];
        System.out.println(canSum(6, arr, 0));
        System.out.println(canSumMemo(6, arr, 0));
    }

    public static boolean canSum(int target, int arr[], int i) {
        sumCount++;
        if (target == 0) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }
        if (arr[i] <= target) {
            return canSum(target - arr[i], arr, i) || canSum(target, arr, i + 1);
        } else {
            return canSum(target, arr, i + 1);
        }
    }

    public static boolean canSumMemo(int target, int arr[], int i) {
        if (solution.containsKey(target)) {
            return solution.get(target);
        }
        if (target == 0) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }
        if (arr[i] <= target) {
            solution.put(target,
                    canSum(target - arr[i], arr, i) || canSum(target, arr, i + 1));

        } else {
            solution.put(target, canSum(target, arr, i + 1));
        }
        return solution.get(target);
    }


}
