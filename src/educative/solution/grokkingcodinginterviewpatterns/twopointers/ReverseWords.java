package educative.solution.grokkingcodinginterviewpatterns.twopointers;

public class ReverseWords {

    public static void main(String[] args) {
        String s = "Hello friend dinesh kumar";
        reverse((s));
        System.out.println(s);
    }

    public  static void reverse(String s){
        String[] arr = s.split(" ");
        int i =0;
        int j = arr.length -1;
        while(i < j){
            String str = arr[i];
            arr[i] = arr[j];
            arr[j] = str;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(str).append(" ");
        }
        s = sb.toString();
    }
}
