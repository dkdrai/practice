package examples;

import java.util.*;
import java.util.stream.Collectors;

public class Conversion {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.stream().forEach(x -> System.out.println(x[0] + " " + x[1]));
        arrayListToArray();
        System.out.println();
        arrayToArrayList();
    }

    static void arrayToArrayList() {
        int arr[] = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    static void arrayListToArray() {
        List<Integer> list = Arrays.asList(1, 2, 3, 45);

        int[] arr = list.stream().mapToInt(i -> i).toArray();
        for (int i : arr) {
            System.out.println(i);
        }
    }


}
