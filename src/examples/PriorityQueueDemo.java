package examples;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String args[]) {

        PriorityQueue<Integer> my_p_queue = new PriorityQueue<>(2,Collections.reverseOrder());
        my_p_queue.offer(1);
        my_p_queue.offer(4);
        my_p_queue.offer(2);
        my_p_queue.offer(3);
        my_p_queue.offer(5);
        System.out.println("The elements in the priority queue are : ");
        while(!my_p_queue.isEmpty())
        System.out.println(my_p_queue.poll());


        // default increasing order
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(3);
        queue.add(2);
        queue.add(5);
        queue.add(4);
        queue.add(1);
        System.out.println("The elements in the priority queue are : ");
        System.out.println(queue.poll());


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b - a);
        priorityQueue.add(150);
        priorityQueue.add(2);
        priorityQueue.add(10);
        priorityQueue.add(100);
        System.out.println();
        System.out.println(priorityQueue.poll());


    }
}