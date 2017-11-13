package com.andreipetrushin.task4.service.interpreter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlusExpression extends AbstractExpression {

    private static final Logger LOGGER = LogManager.getLogger(PlusExpression.class);


    @Override
    public void interpret(Context context) {
        LOGGER.info("Coming context object:  {}", context);
        Double firstValue = context.popValue();
        Double secondValue = context.popValue();
        context.pushValue(firstValue + secondValue);
        LOGGER.info("Context object after execution: {}", context);
    }

    @Override
    public String toString() {
        return "PlusExpression{+}";
    }
}
