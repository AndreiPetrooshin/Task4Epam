package com.andreipetrushin.task4.entity;

import org.junit.Assert;
import org.junit.Test;

public class SimpleComponentTest {

    public static final String WORD = "word";
    private static final SimpleComponent COMPONENT = new SimpleComponent(WORD);


    @Test
    public void shouldReturnCorrectValue(){
        String result = COMPONENT.getValue();
        Assert.assertEquals(WORD,result);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedOperationExceptionWhenCallGet(){
        COMPONENT.get(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedOperationExceptionWhenCallAdd(){
        COMPONENT.add(COMPONENT);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedOperationExceptionWhenCallGetAll(){
        COMPONENT.getAll();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedOperationExceptionWhenCallRemove(){
        COMPONENT.remove(COMPONENT);
    }


}
