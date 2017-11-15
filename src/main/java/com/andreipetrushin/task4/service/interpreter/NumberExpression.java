package com.andreipetrushin.task4.service.interpreter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberExpression extends AbstractExpression {

    private static final Logger LOGGER = LogManager.getLogger(NumberExpression.class);
    private double number;

    public NumberExpression(double number) {
        this.number = number;
    }


    @Override
    public void interpret(Context context) {
        LOGGER.info("Coming context object:  {}", context);
        context.pushValue(number);
        LOGGER.debug("Context object after execution: {}", context);
    }

    @Override
    public String toString() {
        return "NumberExpression{" +
                "number=" + number +
                '}';
    }
}
