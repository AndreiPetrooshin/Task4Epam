package com.andreipetrushin.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite  implements Component{

    private List<Component> list = new ArrayList<>();


    @Override
    public Component get(int id) {
        return list.get(id);
    }

    @Override
    public void add(Component component) {
            list.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return list.remove(component);
    }

    @Override
    public List<Component> getAll() {
        return list;
    }

    @Override
    public String getValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composite composite = (Composite) o;

        return list != null ? list.equals(composite.list) : composite.list == null;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }
}
