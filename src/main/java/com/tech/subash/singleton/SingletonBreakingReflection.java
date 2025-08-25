package com.tech.subash.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonBreakingReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        SingletonMultiThread singletonMultiThread = SingletonMultiThread.getInstanceAsUsual();

        Constructor<?> constructor = SingletonMultiThread.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonMultiThread singletonMultiThreadTwo = (SingletonMultiThread) constructor.newInstance();
        System.out.println(singletonMultiThread.hashCode() + " "+ singletonMultiThreadTwo.hashCode());

    }
}
