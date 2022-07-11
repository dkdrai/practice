package adtiya.verma.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class DistinctIds {

  // Function to find distintc id's
  static int distinctIds(int n, ArrayList<Integer> arr, int mi) {
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    int count = 0;
    int size = 0;
    for (int i = 0; i < n; i++) {
      if (m.containsKey(arr.get(i)) == false) {
        m.put(arr.get(i), 1);
        size++;
      } else {
        m.put(arr.get(i), m.get(arr.get(i)) + 1);
      }
    }


    return size - count;
  }

  //Driver method to test above function
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int arr[] = {1, 2, 3, 1, 2, 2, 1};
    int m = 3;
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(1);
    list.add(2);
    list.add(2);
    list.add(1);

    System.out.println(distinctIds(arr.length, list, m));
  }



}