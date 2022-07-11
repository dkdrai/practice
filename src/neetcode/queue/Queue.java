package neetcode.queue;

public class Queue {


  private static class Node {

    private int data;
    private Node next;

    private Node(int data) {
      this.data = data;
    }
  }

  private Node head, tail;

  public void enqueue(int data) {
    Node node = new Node(data);
    if (tail != null) {
      tail.next = node;
    }
    tail = node;
    if (head == null) {
      head = node;
    }
  }

  public int dequeue() {
    int data = head.data;
    if (head != null) {
      head = head.next;
    }
    if (head == null) {
      tail = null;
    }
    return data;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int peek() {
    return head.data;
  }

  public static void main(String args[]) {
    Queue queue = new Queue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }
}
