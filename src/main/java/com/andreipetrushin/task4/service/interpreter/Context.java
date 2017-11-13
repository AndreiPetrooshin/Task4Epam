package com.andreipetrushin.task4.service.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Deque;
import java.util.LinkedList;


public class Context {

    private static final Logger LOGGER = LogManager.getLogger(Context.class);
    private Deque<Double> deque = new LinkedList<>();

    public Double popValue() {
        LOGGER.info("Before pop: {}", deque);
        double value = deque.pop();
        LOGGER.info("After pop, value: " + value + " : {}", deque);
        return value;
    }

    public void pushValue(Double value) {
        LOGGER.info("Pushing the value: "+ value + " to {}", deque);
        this.deque.push(value);
        LOGGER.info("After pushing: {}", deque);
    }

    @Override
    public String toString() {
        return "Context{" +
                "deque=" + deque +
                '}';
    }
}
