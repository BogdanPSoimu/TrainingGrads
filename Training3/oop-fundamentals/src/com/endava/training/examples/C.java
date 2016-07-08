package com.endava.training.examples;

/**
 * Created by bsoimu on 7/8/2016.
 */
public class C extends B {

    public C() {
    }

    public void f() {
        System.out.println("Hello from C");
    }

    public void f(int a) {
        System.out.println("Hello from C - 1 arg");
    }

    public void f(int a, String b) {
        System.out.println("Hello from C - 2 arg");
    }
}
