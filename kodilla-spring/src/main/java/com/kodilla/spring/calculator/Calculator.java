package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

    @Autowired
    private Display display;

    public double add(double a, double b){
        display.displayValue(a);
        display.displayValue(b);
        return a+b;
    }

    public void sub(double a, double b){
        display.displayValue(a-b);
    }

    public double mul(double a, double b){
        display.displayValue(a);
        display.displayValue(b);
        return a*b;
    }

    public double div(double a, double b){
        display.displayValue(a);
        display.displayValue(b);
        return a/b;
    }
}
