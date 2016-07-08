package com.endava.training.shape.impl;

import com.endava.training.shape.Shape2D;

import static java.lang.Math.sqrt;

/**
 * Created by bsoimu on 7/8/2016.
 */
public class Triangle implements Shape2D{
    private int x;
    private int y;
    private int z;

    public Triangle(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double computePerimeter() {
        return (double)(x + y + z);
    }

    public double computeArea() {
        double p = (double) (x + y + z) / (double) 2;
        double area = p*(p - x) * (p - y) * (p - z);
        return sqrt(p);
    }
}

