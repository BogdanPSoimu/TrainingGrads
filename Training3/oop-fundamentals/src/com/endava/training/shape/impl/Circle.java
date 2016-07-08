package com.endava.training.shape.impl;

import com.endava.training.shape.Shape2D;

/**
 * Created by bsoimu on 7/8/2016.
 */
public class Circle implements Shape2D{
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    public double computePerimeter(){
        return Math.PI*2*r;
    }

    public double computeArea(){
        return Math.PI*r*r;

    }
}
