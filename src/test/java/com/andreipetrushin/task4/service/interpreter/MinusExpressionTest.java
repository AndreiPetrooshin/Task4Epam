package com.andreipetrushin.task4.service.interpreter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinusExpressionTest {
    private static final double FIRST_NUMBER = 10;
    private static final double SECOND_NUMBER = 20;
    private static final double MULTIPLY_RESULT = FIRST_NUMBER-SECOND_NUMBER;
    private MinusExpression expression;
    private Expression left;
    private Expression right;

    @Before
    public void initBeforeClass(){
        left = new NumberExpression(FIRST_NUMBER);
        right = new NumberExpression(SECOND_NUMBER);
        expression = new MinusExpression(left,right);
    }


    @Test
    public void shouldMultiplyFirstAndSecondNumber(){
        double result = expression.interpret();
        Assert.assertEquals(MULTIPLY_RESULT,result,0.01);
    }
}
