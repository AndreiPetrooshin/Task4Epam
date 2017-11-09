package com.andreipetrushin.task4.interpreter;

public class DivideExpression implements Expression{

    private Expression left;
    private Expression right;

    public DivideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret() {
        return left.interpret()/ right.interpret();

    }
}
