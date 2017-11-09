package com.andreipetrushin.task4.entity;

public class TextEntity implements Entity {

    private String context= null;

    public TextEntity(String context) {
        this.context = context;
    }

    @Override
    public String getContext() {
        return context;
    }

    @Override
    public void setContext(String context) {
            this.context = context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextEntity that = (TextEntity) o;

        return context != null ? context.equals(that.context) : that.context == null;
    }

    @Override
    public int hashCode() {
        return context != null ? context.hashCode() : 0;
    }
}
