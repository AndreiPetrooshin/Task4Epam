package com.andreipetrushin.task4.composite;

import com.andreipetrushin.task4.entity.TextEntity;

import java.util.LinkedList;

public class TextComposite implements Component {

    private LinkedList<Component> components = new LinkedList<>();
    private TextEntity entity;

    public TextComposite(TextEntity entity) {
        this.entity = entity;
    }

    public TextComposite() {
    }

    @Override
    public String getEntityContent() {
        return entity.getContext();
    }

    @Override
    public Component pop() {
        return components.pop();
    }

    @Override
    public void push(Component component) {
        components.push(component);
    }

    @Override
    public boolean remove(Component component) {
        return components.remove(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (components != null ? !components.equals(that.components) : that.components != null) return false;
        return entity != null ? entity.equals(that.entity) : that.entity == null;
    }

    @Override
    public int hashCode() {
        int result = components != null ? components.hashCode() : 0;
        result = 31 * result + (entity != null ? entity.hashCode() : 0);
        return result;
    }
}
