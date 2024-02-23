package educative.solution.grokkingcodinginterviewpatterns.twopointers;

import datastructures.LinkedList;
import datastructures.ListNode;
import datastructures.PrintList;

import java.util.Arrays;

/*
* Solution summary
Two pointers, right and left, are set at the head node.
Move the right pointer n steps forward.
If right reaches NULL, return head's next node.
Move both right and left pointers forward till right reaches the last node.
Relink the left node to the node at left's next to the next node.
Return head.
*/
class RemoveNthNode {

    /*Two pointers, left and right, are set at the head node. Move the right pointer n steps forward. After doing that, both pointers are exactly separated by n nodes apart. Start moving both pointers forward until the right pointer reaches the last node. At this point, the left pointer will be pointing to the node before the target node, i.e., the
�
�
ℎ
n
th

 last node. We relink the left node to the node following the left’s next node.

If the right pointer reaches NULL while moving it n steps forward, it means that the head node should be removed. We return the head's next node.*/
    public static ListNode removeNthLastNode(ListNode head, int n) {
        ListNode right = head;
        ListNode left = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
    }

    // Driver Code
    public static void main(String[] args) {
        Integer[][] inputs = {
                {23, 89, 10, 5, 67, 39, 70, 28},
                {34, 53, 6, 95, 38, 28, 17, 63, 16, 76},
                {288, 224, 275, 390, 4, 383, 330, 60, 193},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12}
        };

        int[] n = {4, 1, 6, 9, 11};

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            //inputLinkedList.createLinkedList(Arrays.asList(new Integer[]{(Integer) inputs[i]}));
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tn = " + n[i]);
            System.out.print("\n\tUpdated Linked List:\t");
            PrintList.printListWithForwardArrow(removeNthLastNode(inputLinkedList.head, n[i]));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}