package com.andreipetrushin.task4.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Composite  implements Component{

    private static final Logger LOGGER = LogManager.getLogger(Composite.class);
    private List<Component> list = new ArrayList<>();


    @Override
    public Component get(int id) {
        LOGGER.info("Component list: {}", list);
        Component component = list.get(id);
        LOGGER.info("Get Component by id - {}, component: {}", id, component);
        return component;
    }

    @Override
    public void add(Component component) {
            LOGGER.info("Adding the component: {}; to list: {}", component,list);
            list.add(component);
            LOGGER.info("List after adding: {}", list);
    }

    @Override
    public boolean remove(Component component) {
        LOGGER.info("Removing the component: {}; from list: {}", component,list);
        boolean value = list.remove(component);
        LOGGER.info("List after removing: {}", list);
        return value;
    }

    @Override
    public List<Component> getAll() {
        LOGGER.info("Getting all components from list: {}", list);
        return list;
    }

    @Override
    public String getValue() {
        LOGGER.error("Unsupported method calling!");
        throw new UnsupportedOperationException();
    }


    @Override
    public String toString() {
        return "Composite{" +
                "list=" + list +
                '}';
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
