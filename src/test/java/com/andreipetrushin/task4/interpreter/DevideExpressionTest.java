package com.andreipetrushin.task4.interpreter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DevideExpressionTest {

    private static final double FIRST_NUMBER = 10.4;
    private static final double SECOND_NUMBER = 20.3;
    private static final double MULTIPLY_RESULT = FIRST_NUMBER/SECOND_NUMBER;
    private DivideExpression expression;
    private Expression left;
    private Expression right;

    @Before
    public void initBeforeClass(){
        left = new NumberExpression(FIRST_NUMBER);
        right = new NumberExpression(SECOND_NUMBER);
        expression = new DivideExpression(left,right);
    }


    @Test
    public void shouldDevideFirstAndSecondNumber(){
        double result = expression.interpret();
        Assert.assertEquals(MULTIPLY_RESULT,result,0.01);
    }
}
