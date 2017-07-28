package com.skevary.deadlock;

public class A {
    synchronized void foo(B b) {
    String name = Thread.currentThread().getName();
        System.out.println(name + "login in method A.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "try call method last()");
        b.last();


    }
    synchronized void last(){
        System.out.println("In method A.last();");
    }

}
