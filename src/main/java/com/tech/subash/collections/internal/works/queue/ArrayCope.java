package com.tech.subash.collections.internal.works.queue;

import java.util.Arrays;

public class ArrayCope {
    public static void main(String[] args) {
        String es[] =new String[] {"10","30","20","40","50"};
        int size = es.length;
        int newSize = size - 1;
       // src – the source array.
       //         srcPos – starting position in the source array.
       //           dest – the destination array.
        //        destPos – starting position in the destination data.
        //length – the number of array elements to be copied.
        //               src,  srcPos, dest,  destPos, length
        System.arraycopy(es, 3, es, 2, 2);
        System.out.println("before  " + Arrays.toString(es));
        es[newSize] = null;
        System.out.println("after "+Arrays.toString(es));


    }
}
