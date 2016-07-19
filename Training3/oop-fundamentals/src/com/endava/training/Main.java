package com.endava.training;

import com.endava.training.examples.A;
import com.endava.training.examples.B;
import com.endava.training.examples.C;
import com.endava.training.shape.impl.Circle;
import com.endava.training.shape.impl.Square;
import com.sun.org.apache.xpath.internal.SourceTreeManager;

/**
 * Created by bsoimu on 7/8/2016.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello OOP");


        Circle circle = new Circle(5);
        System.out.println(circle.computeArea());


        A a = new B(); a.f();
        B b = new C(); b.f(4);
        A a1 = new C(); a1.f(5,"abc");


    }
}
