package educative.solution.grokkingcodinginterviewpatterns.kwaymerge;

import datastructures.LinkedList;
import datastructures.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(List<LinkedList> lists) {

        ListNode head = null;
        ListNode current = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.data - b.data);
        for(int i =0; i<lists.size(); i++){
            if(lists.get(i).head != null){
                queue.offer(lists.get(i).head);
            }
        }
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            if(current == null) {
                current = node;
                head = current;
            }else{
                current.next = node;
                current = current.next;
            }
            if(node.next != null)
            queue.offer(node.next);
        }
        return head;
    }
}
