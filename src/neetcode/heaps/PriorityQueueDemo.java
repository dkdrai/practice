package neetcode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
   public static void main(String args[]){
      int arr[] = {1,20,3,40,5,};
     PriorityQueue<Integer> my_p_queue = new PriorityQueue<>(2, Collections.reverseOrder());
      my_p_queue.offer(1);
      my_p_queue.offer(4);

      my_p_queue.offer(2);
      my_p_queue.offer(3);
      my_p_queue.offer(5);
      System.out.println("The elements in the priority queue are : ");
      my_p_queue.poll();
      System.out.println(my_p_queue);

     PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
      queue.add(3);
      queue.add(2);
      queue.add(5);
      queue.add(4);
      queue.add(1);
      System.out.println("The elements in the priority queue are : ");
      System.out.println(queue);

   }
}