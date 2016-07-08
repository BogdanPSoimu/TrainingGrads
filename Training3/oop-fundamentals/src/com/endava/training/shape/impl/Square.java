package com.endava.training.shape.impl;

import com.endava.training.shape.Shape2D;

/**
 * Created by bsoimu on 7/8/2016.
 */
public class Square implements Shape2D{
    private int x;

    public Square(int x) {
        this.x = x;
    }

    public double computeArea(){
        return (double)x*x;
    }

    public double computePerimeter(){
        return (double)4*x;
    }
}

