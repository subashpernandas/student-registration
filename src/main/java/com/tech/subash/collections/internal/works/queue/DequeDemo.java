package com.tech.subash.collections.internal.works.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {  // Double Ended Queue
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        dq.addLast(2);
        dq.addLast(3);
        System.out.println(dq);
    }
}
