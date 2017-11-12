package com.andreipetrushin.task4.service.interpreter;

public class PlusExpression extends AbstractExpression {


    @Override
    public void interpret(Context context) {
        Double firstValue = context.popValue();
        Double secondValue = context.popValue();
        context.pushValue(firstValue + secondValue);
    }
}
