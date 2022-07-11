package neetcode.linkedlist;

public class FindtheDuplicateNumber {


  //287. Find the Duplicate Number
  //https://leetcode.com/problems/find-the-duplicate-number/
  public int findDuplicate(int[] nums) {
    if (nums.length > 1)
    {
      int slow = nums[0];
      int fast = nums[nums[0]];
      while (slow != fast)
      {
        slow = nums[slow];
        fast = nums[nums[fast]];
      }

      fast = 0;
      while (slow != fast  )
      {
        fast = nums[fast];
        slow = nums[slow];
      }
      return slow;
    }
    return -1;
  }
}
