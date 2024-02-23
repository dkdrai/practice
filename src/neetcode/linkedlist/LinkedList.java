package neetcode.linkedlist;

import datastructures.ListNode;

public class LinkedList {


  ListNode head;
  int length = 0;

  public static void main(String ar[]) {
    LinkedList list = new LinkedList();
    list.insertAtBeginning(2);
    list.insertAtBeginning(1);
    list.insertAtLast(4);
    list.insertAtPosition(3, 2);
    list.printList();
  }

  public int removeFromBegin() {
    ListNode current = head;
    head = head.next;
    current.next = null;
    return current.data;
  }

  public ListNode removeFromEnd() {
    if (head == null) {
      return null;
    }
    ListNode p = head, q = null, next = head.next;
    if (next == null) {
      head = null;
      return p;
    } else {
      while ((next = p.next) != null) {
        q = p;
        p = next;
      }
      q.next = null;
      return p;
    }
  }

  public void printList() {
    ListNode current = head;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }

  public void insertAtBeginning(int data) {
    ListNode ListNode = new ListNode(data);
    ListNode.next = head;
    head = ListNode;
    length++;
  }

  public void insertAtLast(int data) {
    ListNode ListNode = new ListNode(data);
    if (head == null) {
      head = ListNode;
      length++;
      return;
    }
    ListNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = ListNode;
    length++;
  }


  public void insertAtPosition(int data, int position) {
    ListNode current = head;
    if (position == 0) {
      head = new ListNode(data);
    } else {
      for (int i = 1; i < position; i++) {
        current = current.next;
      }
      ListNode ListNode = new ListNode(data);
      ListNode.next = current.next;
      current.next = ListNode;
    }
    length++;
  }

  public int getLength(ListNode head) {
    int length = 0;
    ListNode current = head;
    while (current != null) {
      length++;
      current = current.next;
    }
    return length;
  }


}
