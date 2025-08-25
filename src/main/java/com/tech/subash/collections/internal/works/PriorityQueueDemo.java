package com.tech.subash.collections.internal.works;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(4);
        pq.add(15);
        pq.add(2);

        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }
}
