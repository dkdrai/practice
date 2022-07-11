package adtiya.verma.recursion.ibh;

import java.util.Stack;

public class DeleteMiddileElementOfStackUsingRecursion {

  public static void main(String ar[]) {
    Stack<Integer> stack = new Stack<>();

    stack.push(10);
    stack.push(5);
    stack.push(7);
    stack.push(3);
    stack.push(8);
    stack.push(1);
    System.out.println(stack);
    delete(stack, (stack.size()/2)+1);
    System.out.println(stack);
  }



  static void delete(Stack<Integer> stack, int pos) {
    if (pos==1) {
      stack.pop();
      return;
    }
    int value = stack.pop();
    delete(stack, pos-1);
    stack.push(value);
  }



}
