package com.skevary.funcIntr;

public class StringRevers {
    public static void revers(String rev) {
        String result = "";
        for (int i = rev.length() - 1; i >= 0; i--)
            result += rev.charAt(i);

        System.out.println(result);
    }
}
