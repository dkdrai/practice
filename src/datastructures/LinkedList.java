package datastructures;

// Template for the linked list
public class LinkedList<T> {
    public ListNode head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a others.knapsack.ListNode at head
    // of a linked list.
    public void insertNodeAtHead(ListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }
    
    // returns the node at the specified position(index) of the linked list
    public static ListNode getNode(ListNode head, int pos){
      ListNode ptr = head;
      if (pos != -1){
         int p = 0;
         
            while (p < pos){
              ptr = ptr.next;
              p += 1;
            }
                
            return ptr;
      }
       return ptr;     
    }
    
    // returns the number of nodes in the linked list
    public static int getLength(ListNode head)
    {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    
}