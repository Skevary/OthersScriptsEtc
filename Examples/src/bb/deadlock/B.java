package com.skevary.deadlock;

public class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "login in method B.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "try call method last()");
        a.last();


    }
    synchronized void last(){
        System.out.println("In method B.last();");
    }
}
