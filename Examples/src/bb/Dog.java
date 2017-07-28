package com.skevary;

public class Dog<T> implements A {
    T ob;
    int a;

    void call(String msg) {
        System.out.print("[" + msg);
        System.out.println("]");
    }

    public Dog(T ob) {
        this.ob = ob;
    }

    public T getType() {
        return ob;
    }


    public void setA(int a) {
        this.a = a;
    }
}
