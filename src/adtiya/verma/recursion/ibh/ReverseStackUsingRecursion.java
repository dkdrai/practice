package adtiya.verma.recursion.ibh;

import java.util.Stack;

public class ReverseStackUsingRecursion {

  public static void main(String ar[]) {
    Stack<Integer> stack = new Stack<>();
    stack.push(10);
    stack.push(5);
    stack.push(7);
    stack.push(3);
    stack.push(8);
    stack.push(1);
    System.out.println(stack);
    revese(stack);
    System.out.println(stack);
  }

  private static void revese(Stack<Integer> stack) {
    if (stack.empty()) {
      return;
    }
    int value = stack.pop();
    revese(stack);
    insert(stack, value);
  }

  public static void insert(Stack<Integer> stack, int key) {
    if (stack.isEmpty()) {
      stack.push(key);
      return;
    }
    int value = stack.pop();
    insert(stack, key);
    stack.push(value);
  }

}
