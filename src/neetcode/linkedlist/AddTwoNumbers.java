package neetcode.linkedlist;

public class AddTwoNumbers {

  public static void main(String arg[]){
    ListNode list1 = new ListNode(9);
    list1.next = new ListNode(9);
    list1.next.next = new ListNode(9);
    list1.next.next.next = new ListNode(9);
    list1.next.next.next.next = new ListNode(9);
    list1.next.next.next.next.next = new ListNode(9);
    list1.next.next.next.next.next.next = new ListNode(9);


    ListNode list2 = new ListNode(9);
    list2.next = new ListNode(9);
    list2.next.next = new ListNode(9);
    list2.next.next.next = new ListNode(9);
    System.out.println(addTwoNumbers(list1, list2));
  }

  //2. Add Two Numbers
  //https://leetcode.com/problems/add-two-numbers/
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode c1 = l1;
    ListNode c2 = l2;
    ListNode sentinel = new ListNode(0);
    ListNode d = sentinel;
    int sum = 0;
    while (c1 != null || c2 != null) {
      sum /= 10;
      if (c1 != null) {
        sum += c1.val;
        c1 = c1.next;
      }
      if (c2 != null) {
        sum += c2.val;
        c2 = c2.next;
      }
      d.next = new ListNode(sum % 10);
      d = d.next;
    }
    if (sum / 10 == 1)
      d.next = new ListNode(1);
    return sentinel.next;
  }
}
