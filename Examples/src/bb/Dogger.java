package com.skevary;

public class Dogger implements Runnable {
    String msg;
    Dog dog;
    Thread t;

    public Dogger(String msg, Dog dog) {
        this.msg = msg;
        this.dog = dog;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (dog){
        dog.call(msg);}
    }
}
