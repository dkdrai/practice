import java.util.*;

public class Test {

    public static void main(String args[]) {
        String s = "abc";
        List<String> result = new ArrayList<>();
        permute(s, result,0);
        System.out.println(result);

        int arr[] = {1,2,3};
        List<List<Integer>> subSets = new ArrayList<>();
        subset(arr, subSets, new ArrayList<>(), 0);
        System.out.println(subSets);
    }

    public static void subset(int arr[], List<List<Integer>> result, List<Integer> subList, int n){
        if(n == arr.length){
            result.add(new ArrayList<>(subList));
            return;
        }

        subset(arr, result, subList, n+1);
        subList.add(arr[n]);
        subset(arr, result, subList, n+1);
        subList.remove(subList.size()-1);
    }

    public static void permute(String s, List<String> result, int n) {
        if (n == s.length()) {
            result.add(s);
            return;
        }
        for (int i = n; i < s.length(); i++) {
            char c[] = s.toCharArray();
            swap(c, i, n);
            permute(String.valueOf(c), result, n + 1);
            swap(c, i, n);
        }
    }

    public static void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }


}

