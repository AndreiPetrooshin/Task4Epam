package com.andreipetrushin.task4.composite;



public interface Component {

    Component get(int i);

    void add(Component component);

    boolean remove(Component component);

}
