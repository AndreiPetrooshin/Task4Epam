package com.andreipetrushin.task4.composite;

import com.andreipetrushin.task4.entity.ExpressionEntity;

public class ExpressionComponent implements Component {

    private ExpressionEntity entity = null;

    public ExpressionComponent(ExpressionEntity entity) {
        this.entity = entity;
    }

    public ExpressionComponent() {
    }

    public String getEntityContent() {
        return entity.getContext();
    }

    @Override
    public Component pop() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void push(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressionComponent that = (ExpressionComponent) o;

        return entity != null ? entity.equals(that.entity) : that.entity == null;
    }

    @Override
    public int hashCode() {
        return entity != null ? entity.hashCode() : 0;
    }
}
