package neetcode.binarysearch;

import datastructures.ListNode;

public class RemoveNthNodeFromEndofList {

  //19. Remove Nth Node From End of List
  //https://leetcode.com/problems/remove-nth-node-from-end-of-list/
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head, slow = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    if (fast == null) {
      return head.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return head;
  }
}
