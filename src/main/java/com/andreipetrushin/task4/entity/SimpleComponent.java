package com.andreipetrushin.task4.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SimpleComponent implements Component {

    private static final Logger LOGGER = LogManager.getLogger(SimpleComponent.class);
    private String value;

    public SimpleComponent(String value) {
        LOGGER.info("Setting value to SimpleComponent - {}", value);
        this.value = value;
    }

    @Override
    public Component get(int i) {
        LOGGER.error("Unsupported method calling!");
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Component component) {
        LOGGER.error("Unsupported method calling!");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Component component) {
        LOGGER.error("Unsupported method calling!");
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getAll() {
        LOGGER.error("Unsupported method calling!");
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue() {

        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleComponent that = (SimpleComponent) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SimpleComponent{" +
                "value='" + value + '\'' +
                '}';
    }
}
