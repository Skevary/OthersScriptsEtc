package com.skevary.notify_wait;

public class Q {
    int n;
    boolean flag = false;

    synchronized public int get() {
        while (!flag) try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        flag = false;
        System.out.println("Received: " + n);
        notify();
        return n;
    }

    synchronized public void set(int n) {
        while (flag) try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        this.n = n;
        flag = true;
        System.out.println("Sent: " + n);
        notify();
    }
}
