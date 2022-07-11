package adtiya.verma.recursion.ibh;

import java.util.Stack;

public class SortStackWithRecursion {

  public static void main(String ar[]) {
    Stack<Integer> stack = new Stack<>();

    stack.push(10);
    stack.push(5);
    stack.push(7);
    stack.push(3);
    stack.push(8);
    stack.push(1);
    System.out.println(stack);
    sort(stack);
    System.out.println(stack);

  }

  public static void sort(Stack<Integer> stack) {
    if (stack.size() <= 1) {
      return;
    }
    int key = stack.pop();
    sort(stack);
    insert(stack, key);
  }

  public static void insert(Stack<Integer> stack, int key) {
    if (stack.empty() || stack.peek() < key ) {
      stack.push(key);
      return;
    }
    int top = stack.pop();
    insert(stack, key);
    stack.push(top);
  }
}
