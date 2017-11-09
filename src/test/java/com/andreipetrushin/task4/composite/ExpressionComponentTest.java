package com.andreipetrushin.task4.composite;

import org.junit.Test;

public class ExpressionComponentTest {

    private ExpressionComponent component = new ExpressionComponent();


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
