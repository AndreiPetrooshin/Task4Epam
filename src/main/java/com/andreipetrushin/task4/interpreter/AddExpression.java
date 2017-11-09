package com.andreipetrushin.task4.interpreter;

public class AddExpression implements Expression {

    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public double interpret() {
        return left.interpret() + right.interpret();
    }
}
