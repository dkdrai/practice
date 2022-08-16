package datastructures.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueItemsWithRandomValue {

    private List<Integer> list;
    private Map<Integer, Integer> map;

    public UniqueItemsWithRandomValue() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public static void main(String ar[]) {
        UniqueItemsWithRandomValue randomValue = new UniqueItemsWithRandomValue();
        randomValue.put(10);
        randomValue.put(20);
        randomValue.put(30);
        randomValue.list.add(2, 22);
        randomValue.listElements();
        randomValue.put(40);
        randomValue.put(50);
        randomValue.put(30);
        randomValue.put(40);
        randomValue.listElements();
        randomValue.delete(30);
        randomValue.listElements();
        randomValue.put(30);
        randomValue.listElements();
        System.out.println(randomValue.getRandomValue());
        System.out.println(randomValue.getRandomValue());
        System.out.println(randomValue.getRandomValue());
        System.out.println(randomValue.getRandomValue());
        System.out.println(randomValue.getRandomValue());
    }

    public void listElements() {
        System.out.println("list elements");
        for (Integer value : list) {
            System.out.println(value);
        }
        System.out.println("map elements");
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    public void put(Integer value) {
        if (!map.containsKey(value)) {
            int size = list.size();
            map.put(value, size);
            list.add(value);
        }
    }

    public Integer get(Integer value) {
        if (map.containsKey(value)) {
            return value;
        } else {
            return -1;
        }
    }

    public void delete(Integer value) {
        if (map.containsKey(value)) {
            int index = map.get(value);
            int size = list.size() - 1;
            int old = list.get(size);
            list.set(index, old);
            list.remove(size);
            map.put(old, index);
            map.remove(value);
        }
    }

    public int getRandomValue() {
        int rand = (int) (Math.random() * list.size());
        return list.get(rand);
    }
}
