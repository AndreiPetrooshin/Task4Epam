package com.andreipetrushin.task4.entity;

import java.util.List;

public class SimpleComponent implements Component {

    private String value;

    public SimpleComponent(String value) {
        this.value = value;
    }

    @Override
    public Component get(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getAll() {
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
}
