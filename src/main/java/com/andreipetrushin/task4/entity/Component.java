package com.andreipetrushin.task4.entity;


import java.util.List;

public interface Component {

    Component get(int id);

    void add(Component component);

    boolean remove(Component component);

    List<Component> getAll();

    String getValue();

}
