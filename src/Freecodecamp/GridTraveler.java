package Freecodecamp;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    static Map<String, Long> map = new HashMap<>();

    public static void main(String arg[]) {
        System.out.println(waysMemo(2, 3));
        System.out.println(waysMemo(3, 3));
        System.out.println(waysMemo(18, 18));

        System.out.println(ways(2, 3));
        System.out.println(ways(3, 3));
        System.out.println(ways(18, 18));


    }

    //brute force
    public static long ways(int r, int c) {
        if (r == 0 || c == 0) {
            return 0l;
        }
        if (r == 1 && c == 1) {
            return 1l;
        }
        return ways(r - 1, c) + ways(r, c - 1);
    }

    //brute force
    public static long waysMemo(int r, int c) {
        String key = r + "," + c;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (r == 0 || c == 0) {
            return 0l;
        }
        if (r == 1 && c == 1) {
            return 1l;
        }
        map.put(key, waysMemo(r - 1, c) + waysMemo(r, c - 1));
        return map.get(key);
    }

}
