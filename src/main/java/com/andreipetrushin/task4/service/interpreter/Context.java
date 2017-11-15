package com.andreipetrushin.task4.service.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Deque;
import java.util.LinkedList;


public class Context {

    private static final Logger LOGGER = LogManager.getLogger(Context.class);
    private Deque<Double> deque = new LinkedList<>();

    public Double popValue() {
        double value = deque.pop();
        LOGGER.debug("Pop value: " + value + " : {}", deque);
        return value;
    }

    public void pushValue(Double value) {
        this.deque.push(value);
        LOGGER.debug("Push value - {} to deque: {}", value,deque);
    }

    @Override
    public String toString() {
        return "Context{" +
                "deque=" + deque +
                '}';
    }
}
