package com.tech.subash.singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/*
     Way Of Breaking Singleton
     1) Use Reflection
     2) Serialization & Deserialization
     3) Clone
| Approach                    | Thread-safe | Lazy  | Performance | Best Use                             |
| --------------------------- | ----------- | ----- | ----------- | ------------------------------------ |
| Unsynchronized              | ❌ No        | ✅ Yes | ✅ Fast      | ❌ Never use in multithreaded apps    |
| Synchronized method         | ✅ Yes       | ✅ Yes | ❌ Slower    | Simple apps                          |
| Double-checked locking      | ✅ Yes       | ✅ Yes | ✅ Good      | Most common in real-world            |
| Static holder (inner class) | ✅ Yes       | ✅ Yes | ✅ Excellent | Recommended                          |
| Enum singleton              | ✅ Yes       | ❌ No  | ✅ Excellent | Best for global constants/singletons |

 */
@Slf4j
public class SingletonBreakingUsingClone {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException, ClassNotFoundException, InterruptedException {
        SingletonClone singletonBreakingAndPrevention = SingletonClone.getInstance();
        try {
            SingletonClone cloneObject = (SingletonClone) singletonBreakingAndPrevention.clone();
            System.out.println(singletonBreakingAndPrevention.hashCode() + " " + singletonBreakingAndPrevention.hashCode() + " " + cloneObject.hashCode() + " " + cloneObject.hashCode());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
