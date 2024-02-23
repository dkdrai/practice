package examples;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String args[]) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("key =" + entry.getKey());
            System.out.println("value =" + entry.getValue());
        }
        for (Character c : map.keySet()) {
            System.out.println("key =" + c);
        }

        for (Integer i : map.values()) {
            System.out.println("value =" + i);
        }
    }
}
