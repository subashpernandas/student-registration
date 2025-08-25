package com.tech.subash.common.prgram;

import java.util.PriorityQueue;

public class KthLargest {
    public static void findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            System.out.println("min Heap "+ minHeap);
            if (minHeap.size() > k) {
                System.out.println("min Heap 22 "+ minHeap);
                minHeap.poll();
            }
        }
        System.out.println(minHeap);
        //return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        findKthLargest(arr, 2); // Output: 5
    }
}
