package com.bb.Singleton;

/*
    + Lazy initialization
    + High performance
    - Cannot be used for non-static class fields
*/

public class StaticNestedSingleton {
    public static class SingletonHolder {
        public static final StaticNestedSingleton HOLDER_INSTANCE = new StaticNestedSingleton();
    }

    public static StaticNestedSingleton getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
