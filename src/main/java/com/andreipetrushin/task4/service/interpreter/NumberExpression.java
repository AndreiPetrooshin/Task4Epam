package com.andreipetrushin.task4.service.interpreter;

public class NumberExpression implements Expression {

    private double number;

    public NumberExpression(double number) {
        this.number = number;
    }

    @Override
    public double interpret() {
        return number;
    }
}
