package neetcode.greedy;

//55. Jump Game
//https://leetcode.com/problems/jump-game/
public class JumpGame {


  public static void main(String arg[]) {
    int arr[] = {3, 2, 1, 0, 4};
    //{2, 3, 1, 1, 4};
    System.out.println(canJump(arr));
  }

  public static boolean canJump(int[] nums) {
    int goal = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= goal) {
        goal = i;
      }
    }
    return goal == 0;
  }
}
