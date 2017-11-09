package com.andreipetrushin.task4.composite;

import org.junit.Test;

public class WordComponentTest {

    private WordComponent component = new WordComponent();

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsuporrtedOperationExceptionWhenCallPop(){
        component.pop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsuporrtedOperationExceptionWhenCallPush(){

        component.push(component);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsuporrtedOperationExceptionWhenCallRemove(){
        component.remove(component);
    }


}
