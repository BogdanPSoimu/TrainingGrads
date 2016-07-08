package com.endava.training.examples;

/**
 * Created by bsoimu on 7/8/2016.
 */
public class Simple {
    int i;

    public Simple(int i) {
        i = 5;
    }

    public Simple() {

    }

    class ExtendedSimple extends Simple {
        private int j;

        public ExtendedSimple() {
            super();
            System.out.println("Hello from constructor with 0 args");
        }

        public ExtendedSimple(int i) {
            super(i);
            System.out.println("Hello from constructor with 1 args");
        }

        public ExtendedSimple(int i, int j) {
            super(i);
            this.j = j;
            System.out.println("Hello from constructor with 2 args");
        }
    }
}
