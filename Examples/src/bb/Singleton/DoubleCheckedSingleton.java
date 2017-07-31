package com.bb.Singleton;

/*
    + Lazy initialization
    + High performance
    - Is only Supported with JDK 1.5
*/

public final class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
    }

    public static DoubleCheckedSingleton getInstance() {
        DoubleCheckedSingleton localSingleton = instance;
        if (localSingleton == null) {
            synchronized (DoubleCheckedSingleton.class) {
                localSingleton = instance;
                if (localSingleton == null) instance = localSingleton = new DoubleCheckedSingleton();
            }
        }
        return localSingleton;
    }
}
