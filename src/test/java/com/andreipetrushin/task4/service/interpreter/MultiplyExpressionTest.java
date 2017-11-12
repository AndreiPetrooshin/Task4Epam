package com.andreipetrushin.task4.service.interpreter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MultiplyExpressionTest {

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {100,0,0},
                {500,10.5,5250},
                {-100,5,-500},
                {0,100,0},
                {0,0,0},
        });
    }

    private static MultiplyExpression multiplyExpression = new MultiplyExpression();
    private Context context;
    private double expected;

    public MultiplyExpressionTest (double firstNumber, double secondNumber, double expected) {
        this.context = new Context();
        context.pushValue(firstNumber);
        context.pushValue(secondNumber);
        this.expected = expected;



    }

    @Test
    public void shouldMultiplyTheFirstNumberToSecondAndReturnResult(){
        multiplyExpression.interpret(context);
        double result = context.popValue();
        Assert.assertEquals(expected,result,0.01);

    }

}
