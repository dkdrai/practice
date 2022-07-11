package neetcode.linkedlist;

public class fsp4MiddleoftheLinkedList {

  static ListNode head;

  public static void main(String args[]) {
    push(4);
    push(3);
    push(2);
    push(1);
    push(0);
    //head.next.next.next = head;
    System.out.println(detectLoop().val);

  }


  static public void push(int new_data) {
    ListNode new_node = new ListNode(new_data);
    new_node.next = head;
    head = new_node;
  }

  public static ListNode detectLoop() {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
