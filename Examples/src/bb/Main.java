package com.skevary;

import com.skevary.funcIntr.Lamda.HightTemp;
import com.skevary.funcIntr.MyFunc;

public class Main {
    private static <T> int counter(T[] vals, MyFunc<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++)
            if (f.func(vals[i], v)) count++;
        return count;
    }

    public static void main(String[] args) throws Exception {
        int count;

        HightTemp[] weekDayHights = {
                new HightTemp(89), new HightTemp(82),
                new HightTemp(90), new HightTemp(89),
                new HightTemp(89), new HightTemp(91),
                new HightTemp(86), new HightTemp(83),
        };

        count = counter(weekDayHights, HightTemp::sameTemp, new HightTemp(89));
        System.out.println("89 max temp count:" + count);

        HightTemp[] weekDayHights2 = {
                new HightTemp(32), new HightTemp(12),
                new HightTemp(24), new HightTemp(19),
                new HightTemp(18), new HightTemp(12),
                new HightTemp(-1), new HightTemp(13),
        };

        count = counter(weekDayHights2, HightTemp::lessThanTemp, new HightTemp(12));
        System.out.println("12 less temp count:" + count);

    }
}
