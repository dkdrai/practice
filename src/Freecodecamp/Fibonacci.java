package Freecodecamp;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    static Long result[];
    static Map<Integer, Long> map = new HashMap<>();

    public static void main(String arg[]) {

        System.out.println(fibRec(3l));
        System.out.println(fibRec(7l));
        result = new Long[51];
        Arrays.fill(result, -1l);
        System.out.println(new Date());
        System.out.println(fibMemo(50));
        System.out.println(new Date());
        System.out.println(new Date());
        System.out.println(fibMap(50));
        System.out.println(new Date());
    }

    public static Long fibRec(Long n) {
        if (n <= 2) {
            return 1l;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static Long fibMemo(int n) {

        if (result[n] != -1) {
            return result[n];
        }
        if (n <= 2) {
            return result[n] = 1l;
        }
        result[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return result[n];
    }

    public static Long fibMap(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 2) {
            map.put(n, 1l);
            return 1l;
        }
        map.put(n, fibMap(n - 1) + fibMap(n - 2));
        return map.get(n);

    }
}
