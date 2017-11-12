package com.andreipetrushin.task4.service.interpreter;

public class MinusExpression extends AbstractExpression {

    @Override
    public void interpret(Context context) {
        double firstValue = context.popValue();
        double secondValue = context.popValue();
        context.pushValue(secondValue - firstValue);
    }
}
