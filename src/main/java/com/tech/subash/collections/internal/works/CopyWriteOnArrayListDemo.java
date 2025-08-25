package com.tech.subash.collections.internal.works;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyWriteOnArrayListDemo {
    private static transient volatile Object[] array;

    public static void main(String[] args) {
        setArray(new Object[0]); // initialize on

        List<String> list = Arrays.asList("a","b","c","d","e","f","g","h","i","j");
        for(int i = 0 ; i < 10 ; i++) {
            Object[] es = getArray();
            int len = es.length;
            System.out.println(len);
            es = Arrays.copyOf(es, len + 1);
            es[len] = list.get(i);
            System.out.println("iteration "+ "lenght "+ i  + " "+ len + Arrays.toString(es));
            setArray(es);
        }
    }

    static Object[] getArray() {
        return array;
    }

    static void setArray(Object[] a) {
        array = a;
    }
}
