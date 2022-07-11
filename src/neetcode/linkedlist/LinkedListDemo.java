package neetcode.linkedlist;

public class LinkedListDemo {

  static ListNode head;

  public static void main(String ar[]) {
    insertAtStart(4);
    insertAtStart(2);
    insertAtStart(1);
    insertAtEnd(5);
    //printLinkedList();
/*    insertAtPosition(3, 2);
    printLinkedList();
    deleteAtPosition(0);
    printLinkedList();
    reversRecursive(head);
    System.out.println("after reverse");
    printLinkedList();*/
    ListNode list = new ListNode(1);
    list.next = new ListNode(3);
    list.next.next = new ListNode(5);
    printLinkedList(list);

    ListNode list1 = new ListNode(2);
    list1.next = new ListNode(4);
    list1.next.next = new ListNode(6);
    printLinkedList(list1);
    ListNode merge = merge(list, list1);
    printLinkedList(merge);
  }

  private static void deleteAtPosition(int position) {
    ListNode current = head;
    ListNode prev = null;
    int index = 0;
    if (position == 0) {
      head = head.next;
      return;
    }
    while (index < position) {
      prev = current;
      current = current.next;
      index++;
    }

    if (current == null) {
      prev.next = null;
      return;
    } else if (current.next == null) {
      prev.next = null;
    }
    prev.next = current.next;
  }

  public static void printLinkedList(ListNode head) {
    ListNode current = head;
    System.out.println("the elements are");
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
  }

  public static void insertAtStart(int data) {
    ListNode ListNode = new ListNode(data);
    ListNode.next = head;
    head = ListNode;
  }

  public static void insertAtEnd(int data) {
    ListNode ListNode = new ListNode(data);
    if (head == null) {
      head = ListNode;
    } else {
      ListNode current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = ListNode;
    }
  }

  public static void insertAtPosition(int data, int position) {
    if (head == null && position > 0) {
      return;
    }
    int index = 0;
    ListNode current = head;
    ListNode prev = head;
    while (index < position) {
      prev = current;
      current = current.next;
      index++;
    }
    ListNode ListNode = new ListNode(data);
    prev.next = ListNode;
    ListNode.next = current;
  }

  public static void reverse() {
    ListNode current = head;
    ListNode prev = null;
    ListNode next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
  }

  public static void reversRecursive(ListNode current) {
    if (current.next == null) {
      head = current;
      return;
    }
    reversRecursive(current.next);
    ListNode temp = current.next;
    temp.next = current;
    current.next = null;
  }


  public static ListNode merge(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }
    ListNode head = null;
    if (list1.val < list2.val) {
      head = list1;
      list1 = list1.next;
    } else {
      head = list2;
      list2 = list2.next;
    }

    ListNode tail = head;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        tail.next = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
      }
      tail = tail.next;
    }

    if (list1 != null) {
      tail.next = list1;
    } else if (list2 != null) {
      tail.next = list2;
    }
    return head;
  }
}

