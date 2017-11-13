package com.andreipetrushin.task4.service.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiplyExpression extends AbstractExpression {

    private static final Logger LOGGER = LogManager.getLogger(MultiplyExpression.class);

    @Override
    public void interpret(Context context) {
        LOGGER.info("Coming context object:  {}", context);
        Double firstValue = context.popValue();
        Double secondValue = context.popValue();
        context.pushValue(firstValue * secondValue);
        LOGGER.info("Context object after execution: {}", context);
    }

    @Override
    public String toString() {
        return "MultiplyExpression{*}";
    }
}
