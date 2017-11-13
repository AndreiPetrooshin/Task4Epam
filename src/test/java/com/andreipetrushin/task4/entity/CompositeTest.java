package com.andreipetrushin.task4.entity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class CompositeTest {

    private static final int ID = 1;
    private static final Component EXPECTED = new SimpleComponent("text");
    private static final Logger LOGGER  = LogManager.getLogger(CompositeTest.class);
    private Component composite;
    private List<Component> expectedList;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new SimpleComponent("hello"), new SimpleComponent("text"), new SimpleComponent("it's")},
                {new SimpleComponent("some"), new SimpleComponent("text"), new SimpleComponent("test")},
                {new SimpleComponent("simple"), new SimpleComponent("text"), new SimpleComponent("simple")}
        });
    }

    public CompositeTest(Component c1, Component c2, Component c3) {
        composite = new Composite();
        LOGGER.info("Coming components: c1 - {}, c2 - {}, c3 - {}", c1,c2,c3);
        composite.add(c1);
        composite.add(c2);
        composite.add(c3);

        expectedList = Arrays.asList(c1, c2, c3);
    }

    @Test
    public void shouldAddComponentAndReturnedIt() {
        composite.add(EXPECTED);
        int size = composite.getAll().size() - 1;
        Component result = composite.get(size);
        Assert.assertEquals(EXPECTED, result);
    }


    @Test
    public void shouldReturnAllComponents() {
        List<Component> result = composite.getAll();
        Assert.assertEquals(expectedList, result);
    }

    @Test
    public void shouldReturnCorrectComponentByID() {
        Component result = composite.get(ID);
        Assert.assertEquals(EXPECTED, result);

    }


    @Test
    public void shouldRemoveComponent() {
        int sizeBeforeRemove = composite.getAll().size();
        composite.remove(EXPECTED);
        int sizeAfterRemove = composite.getAll().size();
        Assert.assertNotEquals(sizeBeforeRemove, sizeAfterRemove);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedOperationExceptionWhenCallGetValue(){
        composite.getValue();
    }


}
