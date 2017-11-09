package com.andreipetrushin.task4.composite;

import com.andreipetrushin.task4.entity.ParagraphEntity;

import java.util.LinkedList;

public class ParagraphComposite implements Component {

    private ParagraphEntity entity;
    private LinkedList<Component> components = new LinkedList<>();

    public ParagraphComposite(ParagraphEntity entity) {
        this.entity = entity;
    }

    public ParagraphComposite() {
    }

    public Component pop(){
        return  components.pop();
    }

    public void push(Component component){
        components.push(component);
    }

    public boolean remove(Component component){
        return  components.remove(component);
    }

    public String getEntityContent() {
        return entity.getContext();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParagraphComposite that = (ParagraphComposite) o;

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
