package com.tech.subash.collections.internal.works.queue;

import java.util.PriorityQueue;
import java.util.Queue;

// It Follows Min-Heap Tree -> Default Capacity = 11

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(20);
        priorityQueue.offer(40); // insert
        priorityQueue.add(10);
        priorityQueue.offer(50);
        priorityQueue.add(0);
        System.out.println("queue " + priorityQueue);  // [0, 10, 20, 50, 40]


        // System.out.println("Element "+ priorityQueue.element());  // 8 Returns Head Without Removing
        //System.out.println("Peek "+ priorityQueue.peek());  // 8 Returns Head Without Removing
        while (!priorityQueue.isEmpty()) {
            System.out.println("Remove "+priorityQueue.poll());  // 8,10,20 // Removes and returns head
        }

        System.out.println("After Poll " + priorityQueue);  // []
    }
}
