package neetcode.stack;

import java.util.Stack;

public class BalancedParenthesesinExpression {

  public static void main(String args[]) {
    System.out.println(isBalencedParenthesis("}{{}[]()}"));
  }


  public static boolean isBalencedParenthesis(String exp) {
    Stack<Character> stack = new Stack<>();
    char array[] = exp.toCharArray();
    for (char c : array) {
      if (isclosing(c)) {
        if (stack.isEmpty() || !isMatch(c, stack.pop())) {
          return false;
        }
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }

  public static boolean isclosing(char c) {
    return (c == ']' || c == '}' || c == ')');
  }

  public static boolean isMatch(char current, char popped) {
    if (current == ']' && popped == '[') {
      return true;
    } else if (current == '}' && popped == '{') {
      return true;
    } else if (current == ')' && popped == '(') {
      return true;
    }
    return false;
  }
}
