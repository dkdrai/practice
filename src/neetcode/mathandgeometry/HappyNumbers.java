package neetcode.mathandgeometry;

import java.util.HashMap;
import java.util.Map;

public class HappyNumbers {


  public static void main(String arg[]) {
    System.out.println(isHappy(19));
  }

  //202. Happy Number
  //https://leetcode.com/problems/happy-number/submissions/
  public static boolean isHappy(int n) {
    Map<Integer, Boolean> map = new HashMap<>();
    while (!map.containsKey(n)) {
      map.put(n, true);
      int sum = 0;
      while (n != 0) {
        int value = n % 10;
        sum = sum + (value * value);
        n = n / 10;
      }
      if (sum == 1) {
        return true;
      } else if (sum <= 3) {
        return false;
      }
      n = sum;
    }
    return false;
  }
}
