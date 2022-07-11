package neetcode.stack;

import java.util.Stack;

public class EdatauateReversePolishNotation {

  public static void main(String args[]) {
    String tok[] = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println(edataRPN(tok));
  }

  //150. Edatauate Reverse Polish Notation
  //https://leetcode.com/problems/edatauate-reverse-polish-notation/description/

  public static int edataRPN(String[] tokens) {
    Stack<String> stack = new Stack<>();
    for (String c : tokens) {
      if (c.equals("+") || c.equals("-")
          || c.equals("*")
          || c.equals("/")) {
        int number1 = Integer.valueOf(stack.pop());
        int number2 = Integer.valueOf(stack.pop());
        int value = 0;
        if (c.equals("+")) {
          value = number2 + number1;
        } else if (c.equals("-")) {
          value = number2 - number1;
        } else if (c.equals("/")) {
          value = number2 / number1;
        } else if (c.equals("*")) {
          value = number2 * number1;
        }
        stack.push("" + value);
      } else {
        stack.push(c);
      }
    }
    return Integer.valueOf(stack.pop());
  }


}
