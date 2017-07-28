package com.skevary.notify_wait;

public class Consumer implements Runnable {
    private Q q;

    public Consumer(Q q) {
        this.q = q;
       new Thread(this,"Consumer").start();
    }

    @Override
    public void run() {
        while(true) q.get();
    }
}
