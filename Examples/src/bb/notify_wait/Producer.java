package com.skevary.notify_wait;

public class Producer implements Runnable {
    private Q q;


    public Producer(Q q) {
        this.q = q;
        new Thread(this,"Producer").start();
    }

    @Override
    public void run() {
        int n=0;
        while(true)q.set(n++);
    }
}
