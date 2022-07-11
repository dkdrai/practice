package adtiya.verma.recursion.ibh;

import java.util.ArrayList;
import java.util.List;

public class SortArrayWithRecursion {

  public static void main(String s[]) {
    SortArrayWithRecursion a = new SortArrayWithRecursion();
    List<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(1);
    list.add(3);
    list.add(2);
    System.out.println(list);
    a.sort(list);
    System.out.println(list);
  }

  void sort(List<Integer> list) {
    if (list.size() == 1) {
      return;
    }
    int value = list.remove(list.size() - 1);
    sort(list);
    insert(list, value);
  }

  void insert(List<Integer> list, int value) {
    if (list.size() == 0 || list.get(list.size() - 1) < value) {
      list.add(value);
      return;
    }
    int last = list.remove(list.size() - 1);
    insert(list, value);
    list.add(last);
  }


}
