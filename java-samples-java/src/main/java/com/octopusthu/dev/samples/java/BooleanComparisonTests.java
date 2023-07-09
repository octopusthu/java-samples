package com.octopusthu.dev.samples.java;

public class BooleanComparisonTests {

    public static void main(String[] args) {
        Inner inner = new Inner(true);
        if (Boolean.TRUE == inner.getTesting()) {
            System.out.println("Boolean.TRUE == inner.getTesting()");
        }
    }

    static class Inner {
        private final Boolean testing;

        Inner(Boolean testing) {
            this.testing = testing;
        }

        public Boolean getTesting() {
            return testing;
        }
    }
}
