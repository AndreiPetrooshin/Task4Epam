package com.andreipetrushin.task4.interpreter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddExpressionTest {
    private static final double FIRST_NUMBER = 10;
    private static final double SECOND_NUMBER = 20;
    private static final double MULTIPLY_RESULT = FIRST_NUMBER+SECOND_NUMBER;
    private AddExpression expression;
    private Expression left;
    private Expression right;

    @Before
    public void initBeforeClass(){
        left = new NumberExpression(FIRST_NUMBER);
        right = new NumberExpression(SECOND_NUMBER);
        expression = new AddExpression(left,right);
    }


    @Test
    public void shouldAddFirstAndSecondNumber(){
        double result = expression.interpret();
        Assert.assertEquals(MULTIPLY_RESULT,result,0.01);
    }
}
