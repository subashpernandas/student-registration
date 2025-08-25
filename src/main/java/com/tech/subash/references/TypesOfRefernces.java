package com.tech.subash.references;

import com.tech.subash.interview.Student;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TypesOfRefernces {

    public static void main(String[] args) throws InterruptedException {
        // If you are creating an object and assign to a variable is called
        // String Reference, this one is no eligible for GC
        String s = new String("Hello");

        Student student = new Student();
        student.setAge(23);
        student.setName("subash");

        // Used for implementing memory-sensitive cache. If memory is low, the GC may recliam softly reachable
        // GC will reclaim the object only if memory is low
        // SoftReference<Student> stringSoftReference = new SoftReference<>(student);
        //System.out.println(stringSoftReference.get());

        student = null;

        //Objects referenced only by weak references are collected at the next GC cycle, even if memory is not low
        // At next GC cycle Example For WeakHashMap and listeners
        WeakReference<Student> weakRef = new WeakReference<>(student);
        System.out.println(weakRef.get());

        System.gc();
        Thread.sleep(5000);
        System.out.println(weakRef.get());

    }
}
