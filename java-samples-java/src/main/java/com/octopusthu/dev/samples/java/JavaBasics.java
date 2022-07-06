package com.octopusthu.dev.samples.java;

public class JavaBasics {

    public static void main(String[] args) {
        primitiveTypeUnboxing();
    }

    private static void primitiveTypeUnboxing() {
        Boolean boxed = null;

        // Dangerous unboxing
        try {
            boolean unboxed = boxed;
            System.out.println("unboxed is: " + unboxed);
        } catch (Exception e) {
            System.out.println("Unboxing failed: " + e.getMessage());
        }

        // Proper unboxing
        try {
            boolean converted = Boolean.TRUE.equals(boxed);
            System.out.println("converted is: " + converted);
        } catch (Exception e) {
            System.out.println("Conversion failed: " + e.getMessage());
        }

    }

}
