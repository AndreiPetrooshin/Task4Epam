package com.andreipetrushin.task4.interpreter;

import org.junit.Assert;
import org.junit.Test;

public class NumberExpressionTest {


    private static final double NUMBER = 10.5;
    private NumberExpression expression = new NumberExpression(NUMBER);

    @Test
    public void shouldReturnNUMBER(){
        double result  = expression.interpret();
        Assert.assertEquals(NUMBER,result, 0.01);
    }


}
