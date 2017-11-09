package com.andreipetrushin.task4.composite;

import com.andreipetrushin.task4.entity.SentenceEntity;

import java.util.LinkedList;

public class SentenceComposite implements Component {

    private SentenceEntity entity;
    private LinkedList<Component> components = new LinkedList<>();

    public SentenceComposite(SentenceEntity entity) {
        this.entity = entity;
    }

    public SentenceComposite() {
    }

    public Component pop(){
        return components.pop();
    }

    public void push(Component component){
        components.push(component);
    }

    public boolean remove(Component component){
        return components.remove(component);
    }

    @Override
    public String getEntityContent() {
        return entity.getContext();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SentenceComposite that = (SentenceComposite) o;

        if (entity != null ? !entity.equals(that.entity) : that.entity != null) return false;
        return components != null ? components.equals(that.components) : that.components == null;
    }

    @Override
    public int hashCode() {
        int result = entity != null ? entity.hashCode() : 0;
        result = 31 * result + (components != null ? components.hashCode() : 0);
        return result;
    }
}
