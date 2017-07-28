package com.skevary.generic;


public class Gen<T> {
    T ob;
    public Gen(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    public void getType(){
        System.out.println("Type T: "+ ob.getClass().getName());
    }
}
