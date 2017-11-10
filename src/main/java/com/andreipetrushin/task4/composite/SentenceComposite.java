package com.andreipetrushin.task4.composite;

import java.util.ArrayList;

import java.util.List;

public class SentenceComposite implements Component {


    private List<Component> components = new ArrayList<>();

    public Component get(int i){
        return components.get(i);
    }

    public void add(Component component){
        components.add(component);
    }

    public boolean remove(Component component){
        return components.remove(component);
    }


}
