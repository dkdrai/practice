package neetcode.queue;

import java.util.Stack;

public class QueueWithTwoStacks {

  public static class MyQueue<T> {

    public Stack<T> newStack = new Stack<T>();
    public Stack<T> oldStack = new Stack<T>();

    public void enqueue(T value) {
      newStack.push(value);
    }

    public T dequeue() {
      shiftStack();
      return oldStack.pop();
    }

    public T pop() {
      shiftStack();
      return oldStack.peek();
    }

    private void shiftStack() {
      if (oldStack.isEmpty()) {
        while (!newStack.isEmpty()) {
          oldStack.push(newStack.pop());
        }
      }
    }
  }

  public static void main(String args[]) {
    MyQueue<String> myQueue = new MyQueue<>();
    myQueue.enqueue("a");
    myQueue.enqueue("b");
    myQueue.enqueue("c");
    System.out.println(myQueue.pop());
    System.out.println(myQueue.dequeue());
    System.out.println(myQueue.dequeue());


  }

}
