package neetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

  //22. Generate Parentheses
  //https://leetcode.com/problems/generate-parentheses/
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<String >();
    parenthesis("", n, n, list);
    return list;
  }

  void parenthesis(String s, int left, int right, List<String> list) {
    if (right == 0 && right == 0) {
      //System.out.println(s);
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
