package com.skevary.generic;

public class GenTwoPam<T,V>{
    T tob;
    V vob;

    public GenTwoPam(T tob) {
        this.tob = tob;
    }

    public GenTwoPam(T tob, V vob) {
        this.tob = tob;
        this.vob = vob;
    }

    public T getTob() {
        return tob;
    }

    public void setTob(T tob) {
        this.tob = tob;
    }

    public V getVob() {
        return vob;
    }

    public void setVob(V vob) {
        this.vob = vob;
    }
}
