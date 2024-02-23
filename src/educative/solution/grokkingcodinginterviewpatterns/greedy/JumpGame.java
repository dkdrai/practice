package educative.solution.grokkingcodinginterviewpatterns.greedy;

public class JumpGame {

    public static void main(String[] args) {
        int ar[] = {4, 0, 0, 0, 4};
        System.out.println(jumpGame(ar));
    }

    public static boolean jumpGame(int[] nums) {
        int targetIndex = nums.length - 1;
        for (int i = targetIndex - 1; i >= 0; i--) {
            if (targetIndex <= i + nums[i]) {
                targetIndex = i;
            }
        }
        if (targetIndex == 0)
            return true;
        return false;
    }

}