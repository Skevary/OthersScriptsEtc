package com.skevary.funcIntr.Lamda;

public class HightTemp {
    private int hTamp;

    public HightTemp(int hTamp) {
        this.hTamp = hTamp;
    }

    public boolean sameTemp(HightTemp ht2) {
        return hTamp == ht2.hTamp;
    }

    public boolean lessThanTemp(HightTemp ht2) {
        return hTamp < ht2.hTamp;
    }
}
