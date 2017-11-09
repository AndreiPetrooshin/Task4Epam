package com.andreipetrushin.task4.composite;

import com.andreipetrushin.task4.entity.WordEntity;

public class WordComponent implements Component {

    private WordEntity entity;

    public WordComponent(WordEntity entity) {
        this.entity = entity;
    }

    public WordComponent() {
    }

    public String getEntityContent()
    {
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

        WordComponent that = (WordComponent) o;

        return entity != null ? entity.equals(that.entity) : that.entity == null;
    }

    @Override
    public int hashCode() {
        return entity != null ? entity.hashCode() : 0;
    }
}
