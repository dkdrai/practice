package neetcode.linkedlist;

import datastructures.ListNode;

public class ReorderList {

  static ListNode head;

  //143. Reorder List
  //https://leetcode.com/problems/reorder-list/
  public static void main(String args[]) {

    push(4);
    push(3);
    push(2);
    push(1);
    push(0);
    //head.next.next.next = head;

    if (head == null || head.next == null) {
      return;
    }

    //Find the middle of the list
    ListNode p1 = head;
    ListNode p2 = head;
    while (p2.next != null && p2.next.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }
    System.out.println(p1.data +" "+ p2.data);

    //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
    ListNode mid = p1;
    ListNode second = p1.next;
    while (second.next != null) {
      ListNode current = second.next;
      second.next = current.next;
      current.next = mid.next;
      mid.next = current;
    }

    //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
    p1 = head;
    p2 = mid.next;
    while (p1 != mid) {
      mid.next = p2.next;
      p2.next = p1.next;
      p1.next = p2;
      p1 = p2.next;
      p2 = mid.next;
    }
  }


  static public void push(int new_data) {
    ListNode new_node = new ListNode(new_data);
    new_node.next = head;
    head = new_node;
  }


}
