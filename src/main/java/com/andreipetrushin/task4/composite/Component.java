package com.andreipetrushin.task4.composite;



public interface Component {

    String getEntityContent();

    Component pop();

    void push(Component component);

    boolean remove(Component component);

}
