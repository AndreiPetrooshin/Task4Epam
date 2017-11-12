package com.andreipetrushin.task4.service.interpreter;

public class NumberExpression extends AbstractExpression {

    private double number;

    public NumberExpression(double number) {
        this.number = number;
    }


    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
