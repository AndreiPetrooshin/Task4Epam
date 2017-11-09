package com.andreipetrushin.task4.entity;

public class ExpressionEntity implements Entity {
    private String context = null;

    public ExpressionEntity(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressionEntity that = (ExpressionEntity) o;

        return context != null ? context.equals(that.context) : that.context == null;
    }

    @Override
    public int hashCode() {
        return context != null ? context.hashCode() : 0;
    }
}
