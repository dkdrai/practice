import java.math.BigInteger;
import java.util.*;

public class Result {

    public static void main(String arg[]) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(25);
        list.add(625);
        System.out.println(maxSetSize(list));

    }


    public static int findTotalPower(List<Integer> arr) {
        System.out.print(arr);;
        int n = arr.size(), k = 1, cur = 0;
        long ans = 0;
        long[][] mindp = new long[n][n];
        int[] sum = new int[n + 1];
        for(int num : arr) {
            cur += num;
            sum[k++] = cur;
        }
        for(int i = 0; i < arr.size(); i++) {
            LinkedList<Integer> stack = new LinkedList<>();
            for(int j = i; j < arr.size(); j++) {
                while(!stack.isEmpty() && (arr.get(stack.peekFirst()) > arr.get(j))) {
                    stack.removeFirst();
                }
                stack.addLast(j);
                mindp[i][j] = arr.get(stack.peekFirst());
            }
        }
        for(int i = 0; i < arr.size(); i++) {
            for(int j = i; j < arr.size(); j++) {
                ans += mindp[i][j] * (sum[j + 1] - sum[i]);
            }
        }
        return (int)ans  % 1000000007;

    }


    public static int maxSetSize(List<Integer> riceBags) {
        Map<Integer, BigInteger> map = new HashMap<>();
        for (int i = 0; i < riceBags.size(); i++) {
            int value = riceBags.get(i);
            map.put(value, BigInteger.valueOf(value * value));
        }
        int max = -1;
        for (int i = 0; i < riceBags.size(); i++) {
            BigInteger value = BigInteger.valueOf(riceBags.get(i));
            int count = getCount(value, map);
            max = Math.max(count, max);
        }
        if (max >= 2) return max;
        else return -1;
    }

    public static int getCount(BigInteger value, Map<Integer, BigInteger> map) {
        if (value.equals( 0)) {
            return 0;
        }
        if (map.containsKey(value)) {
            return 1 + getCount(map.getOrDefault(value, BigInteger.ZERO), map);
        } else {
            return 0;
        }
    }

}
