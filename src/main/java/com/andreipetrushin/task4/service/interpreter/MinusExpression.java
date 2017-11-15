package com.andreipetrushin.task4.service.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinusExpression extends AbstractExpression {

    private static final Logger LOGGER = LogManager.getLogger(MinusExpression.class);

    @Override
    public void interpret(Context context) {
        LOGGER.info("Coming context object:  {}", context);
        double firstValue = context.popValue();
        double secondValue = context.popValue();
        context.pushValue(secondValue - firstValue);
        LOGGER.debug("Context object after execution: {}", context);
    }

    @Override
    public String toString() {
        return "MinusExpression{-}";
    }
}
