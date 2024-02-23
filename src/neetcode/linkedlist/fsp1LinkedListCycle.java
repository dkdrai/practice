package neetcode.linkedlist;

import datastructures.ListNode;

public class fsp1LinkedListCycle {

  static ListNode head;

  public static void main(String args[]) {
    push(3);
    push(2);
    push(1);
    //head.next.next.next = head;
    if (detectLoop()) {
      System.out.println("loop found");
    } else {
      System.out.println("no loop found");
    }
  }

  //141. Linked List Cycle
  //https://leetcode.com/problems/linked-list-cycle/
  public static boolean detectLoop() {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }

  static public void push(int new_data) {
    ListNode new_node = new ListNode(new_data);
    new_node.next = head;
    head = new_node;
  }

  public static void printLinkedList() {
    ListNode current = head;
    System.out.println("the elements are");
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }

}
