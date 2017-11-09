package com.andreipetrushin.task4.interpreter;

public class DevideExpression implements Expression{

    private Expression left;
    private Expression right;

    public DevideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret() {
        return left.interpret()/ right.interpret();

    }
}
