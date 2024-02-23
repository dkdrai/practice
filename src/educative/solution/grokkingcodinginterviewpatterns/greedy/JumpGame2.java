package educative.solution.grokkingcodinginterviewpatterns.greedy;

public class JumpGame2 {

    public static void main(String[] args) {
        int arr[] = {2, 0, 1, 0, 2, 3, 6};//{2, 3, 1, 1, 4};
        System.out.println(jump(arr));
        System.out.println(jumpPossible(arr));
    }

    public static boolean jumpPossible(int[] A) {
        int currentIndex = A.length -1;
        for(int i = currentIndex -1; i>=0; i--){
            if(i + A[i] >= currentIndex){
                currentIndex = i;
            }
        }
        if(currentIndex <=0)
            return true;
        return false;
    }

    public static int jump(int[] A) {
    int ans = 0;
    int end = 0;
    int max = 0;
            for(int i =0; i<A.length -1; i++){
                max = Math.max(max, i + A[i]);
                if(i ==end){
                    ans ++;
                    end = max;
                }
            }
            return ans;
    }
}
