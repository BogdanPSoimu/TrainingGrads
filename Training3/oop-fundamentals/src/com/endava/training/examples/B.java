package com.endava.training.examples;

/**
 * Created by bsoimu on 7/8/2016.
 */
public class B extends A {

    public B() {
    }

    public void f() {
        System.out.println("Hello from B");
    }

    public void f(int a) {
        System.out.println("Hello from B - 1 arg");
    }

    public void f(int a, String b) {
        System.out.println("Hello from B - 2 arg");
    }
}
