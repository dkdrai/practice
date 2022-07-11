package neetcode.stack;

import java.util.Stack;

public class MinimumStack {
  Stack<Integer> stack;
  Stack<Integer> stack2;

  public static void main(String ar[]){
    MinStack stack = new MinStack();
    stack.push(-2);
    stack.push(0);
    stack.push(-3);
    System.out.println(stack.getMin());
    stack.pop();
    System.out.println(stack.top());
    System.out.println(stack.getMin());
  }

  public MinimumStack() {
    stack = new Stack<>();
    stack2 = new Stack<>();
  }

  public void push(int data) {
    if (stack.empty()) {
      stack.push(data);
      stack2.push(data);
      return;
    }
    stack.push(data);
    int currentMin = stack2.peek();
    if (data < currentMin) {
      stack2.push(data);
    } else {
      stack2.push(currentMin);
    }

  }

  public void pop() {

    stack2.pop();
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return stack2.peek();
  }
}
