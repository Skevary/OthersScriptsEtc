package com.bb.Singleton;

/*
    + Lazy initialization
    - Poor performance (critical section) in most typical access
*/

public final class SynchronizedAccessorSingleton {
    private static SynchronizedAccessorSingleton instance;

    private SynchronizedAccessorSingleton() {
    }

    public static synchronized SynchronizedAccessorSingleton getInstance() {
        if (instance == null) instance = new SynchronizedAccessorSingleton();
        return instance;
    }
}
