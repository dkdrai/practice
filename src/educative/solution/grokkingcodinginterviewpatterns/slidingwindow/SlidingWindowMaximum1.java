package educative.solution.grokkingcodinginterviewpatterns.slidingwindow;

public class SlidingWindowMaximum1 {
	public static int[] findMaxSlidingWindow(int[] nums, int w) {

		int left = 0;
		int right = w - 1;
	
		int result [] = new int [nums.length - w +1];

		while( right < nums.length){
			result[left] = getMax(nums, left, right);
			left ++;
			right ++;
		}
		
		return result;
	}

	public static int getMax(int nums[], int start, int end){
		int max = nums[start];
		for(int i = start+1; i<= end; i++){
			if(max < nums[i]){
				max = nums[i];
			}
		}
		return max;
	}
}