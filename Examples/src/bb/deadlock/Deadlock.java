package com.skevary.deadlock;

public class Deadlock implements Runnable{
    A a = new A();
    B b = new B();

    public Deadlock() {
        Thread.currentThread().setName("General thread ");

        Thread thread = new Thread(this, "Concurrency thread ");
        thread.start();

        a.foo(b);
        System.out.println("Back to general thread");
    }

    @Override
    public void run() {
        b.bar(a);
        System.out.println("Back to another thread");
    }
}
