package neetcode.linkedlist;


public class Reverse {

  public static void main(String args[]) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    ListNode current = node;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
    ListNode head = reverse(node);
    current = head;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
  }


  public static ListNode reverse(ListNode current) {
    ListNode prev = null;
    ListNode next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }


}
