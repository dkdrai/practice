package adtiya.verma.recursion.inputoutput;

import java.util.ArrayList;
import java.util.List;

public class BalencedParenthesis {

  public static void main(String ar[]) {
    List<String> list = new ArrayList<String >();
    parenthesis("", 2, 2, list);
    System.out.println(list);
  }

  private static void parenthesis(String s, int left, int right, List<String> list) {
    if (left == 0 && right == 0) {
      list.add(s);
      return;
    }
    if (left > 0) {
      parenthesis(s.concat("("), left - 1, right, list);
    }
    if (right > left) {
      parenthesis(s.concat(")"), left, right - 1, list);
    }
  }
}
