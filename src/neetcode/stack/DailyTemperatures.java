package neetcode.stack;

import java.util.Stack;

public class DailyTemperatures {

  public static void main(String ar[]) {
    int arr[] = {60, 59, 80, 70};
    int sol[] = dailyTemperatures(arr);
    for (int i : sol) {
      System.out.println(i);
    }
  }

  //739. Daily Temperatures
  //https://leetcode.com/problems/daily-temperatures/
  public static int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] ret = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int idx = stack.pop();
        ret[idx] = i - idx;
      }
      stack.push(i);
    }
    return ret;
  }
}
