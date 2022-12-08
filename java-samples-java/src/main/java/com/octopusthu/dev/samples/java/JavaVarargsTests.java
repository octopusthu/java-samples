package com.octopusthu.dev.samples.java;

import java.util.Arrays;

public class JavaVarargsTests {

    public static void main(String[] args) {
        varargsMethod("a");
        varargsMethod("b", (String) null);
        varargsMethod("c", (String[]) null);
        varargsMethod("d", new String[]{});
    }

    private static void varargsMethod(String arg, String... varargs) {
        System.out.println(arg + ": " + Arrays.toString(varargs));
    }

}
