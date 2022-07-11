package neetcode.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import neetcode.linkedlist.ListNode;

public class MergeKsortedLinkedList {

  public static void main(String args[]) {

    ListNode listNode1 = new ListNode(4);
    listNode1.next = new ListNode(8);

    ListNode listNode2 = new ListNode(2);
    listNode2.next = new ListNode(6);

    ListNode listNode3 = new ListNode(3);
    listNode3.next = new ListNode(7);

    ListNode listNode4 = new ListNode(1);
    listNode4.next = new ListNode(5);

    ListNode[] lists = {listNode1, listNode2, listNode3, listNode4};
    ListNode head = mergeKLists(lists);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }

  }

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        if (o1.val < o2.val) {
          return -1;
        } else if (o1.val == o2.val) {
          return 0;
        } else {
          return 1;
        }
      }
    });
    for (ListNode node : lists) {
      if (node != null) {
        queue.add(node);
      }
    }
    ListNode head = new ListNode(0);
    ListNode tail = head;
    while (!queue.isEmpty()) {
      tail.next = queue.poll();
      tail = tail.next;
      if (tail.next != null) {
        queue.add(tail.next);
      }
    }
    return head.next;
  }
}
