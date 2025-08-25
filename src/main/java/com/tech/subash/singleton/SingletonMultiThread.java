package com.tech.subash.singleton;

public class SingletonMultiThread {
    private static SingletonMultiThread singletonMultiThread = null;

    private SingletonMultiThread(){
        if (singletonMultiThread == null) {
            throw  new RuntimeException("try to singleton thread");
        }
    }

    public static SingletonMultiThread getInstanceAsUsual(){
        if(singletonMultiThread == null) {
            singletonMultiThread = new SingletonMultiThread();
            return singletonMultiThread;
        } else {
            return singletonMultiThread;
        }
    }

    // instead of method level synchronized
    public static SingletonMultiThread getInstanceForDoubleCheck(){
        if(singletonMultiThread == null) {
            synchronized (SingletonMultiThread.class) {
                if (singletonMultiThread == null) {
                    singletonMultiThread = new SingletonMultiThread();
                    return singletonMultiThread;
                }
            }
        }
        return singletonMultiThread;
    }

    private static class Holder {
        private static final SingletonMultiThread INSTANCE = new SingletonMultiThread();
    }

    public static SingletonMultiThread getInstanceUpdated() {
        return Holder.INSTANCE;
    }
}
