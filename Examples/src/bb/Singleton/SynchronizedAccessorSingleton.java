package com.bb.Singleton;

/*
    + Lazy initialization
    - Poor performance (critical section) in most typical access
*/

public class SynchronizedAccessorSingleton {
    private static SynchronizedAccessorSingleton instance;

    public static synchronized SynchronizedAccessorSingleton getInstance() {
        if (instance == null) instance = new SynchronizedAccessorSingleton();
        return instance;
    }
}
