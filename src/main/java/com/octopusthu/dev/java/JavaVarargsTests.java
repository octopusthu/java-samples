package com.octopusthu.dev.java;

import java.util.Arrays;

public class JavaVarargsTests {

    public static void main(String[] args) {
        varargsMethod("a");
        varargsMethod("b", (String) null);
        varargsMethod("c", (String[]) null);
    }

    private static void varargsMethod(String arg, String... varargs) {
        System.out.println(Arrays.toString(varargs));
    }

}
