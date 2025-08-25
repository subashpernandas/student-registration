package com.tech.subash.collections.internal.works.queue;

import java.util.*;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();  // LIFO extends From Vector
        stack.push(1);
        stack.push(15);
        stack.push(150);
        System.out.println("Stack impl "+ stack); // Print like this [1,15,150] // But [150,15,1]
        System.out.println("Traditional Stack POP "+ stack.pop()); // Remove 150  // synchronized
        System.out.println("Traditional Stack PEEK "+ stack.peek()); // return 15  // synchronized
        System.out.println(stack.isEmpty());


        Deque<String> stackInModerWay = new ArrayDeque();
        stackInModerWay.push("A");
        stackInModerWay.push("B");
        stackInModerWay.push("C");
        System.out.println("Modern Stack " + stackInModerWay);  // [C, B, A]
        System.out.println("POP in Modern Way " + stackInModerWay.pop());
        System.out.println("PEEK in Modern Way " + stackInModerWay.peek());
        System.out.println("Modern Stack After POP " + stackInModerWay);  // [ B, A]
        // INSERT
        stackInModerWay.addFirst("S");
        stackInModerWay.addLast("H");
        System.out.println(stackInModerWay); // [S,B,A,H]
        stackInModerWay.offerFirst("P");
        stackInModerWay.offerLast("S");
        System.out.println(stackInModerWay); // [P, S, B, A, H, S]


        // ACCESS
        System.out.println("peek first " +stackInModerWay.peekFirst()); // P return null if empty
        System.out.println("peek last "+ stackInModerWay.peekLast()); //S    same
        System.out.println("get first "+stackInModerWay.getFirst()); // P throw exception if empty
        System.out.println("get last "+ stackInModerWay.getLast()); // S  same
        System.out.println("contains " +stackInModerWay.contains("H"));

        //DELETE
        System.out.println("poll first " +stackInModerWay.pollFirst()); // remove first element of front
        System.out.println("poll last "+stackInModerWay.pollLast());
        System.out.println("remove first "+stackInModerWay.removeFirst());
        System.out.println("remove last "+stackInModerWay.removeLast());

        //UTILITY
        Iterator<String> itr  = stackInModerWay.iterator();
        Iterator<String> itr1  = stackInModerWay.descendingIterator();

        while (itr1.hasNext()){
            System.out.println("Desc Itr " + itr1.next());
        }

        for(String s : stackInModerWay){
            if(s.equalsIgnoreCase("S")){
                stackInModerWay.pop();
            }
        }

        System.out.println("Desc "+ stackInModerWay); // [B, A]
        stackInModerWay.offer("A");
        System.out.println("Offer " +stackInModerWay); // [B,A,A]
        stackInModerWay.removeFirstOccurrence("A");
        System.out.println("after remove fisrst occurance " +stackInModerWay); // [B,A]
        System.out.println("element " +stackInModerWay.element()); // [B]


    }
}
