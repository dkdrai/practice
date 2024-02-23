package educative.solution.grokkingcodinginterviewpatterns.linkedlist;

import datastructures.LinkedList;
import datastructures.ListNode;

public class Reverse {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedList list = new LinkedList();
        list.createLinkedList(arr);

        ListNode current = list.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("after reverse");
        list.head = reverse(list.head);
        current = list.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
