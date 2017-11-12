package com.andreipetrushin.task4.service.interpreter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NumberExpressionTest {

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {10,10},
                {1600.100,1600.100},
                {-100,-100},
                {-5.5,-5.5},
                {0,0},
        });
    }

    private static NumberExpression numberExpression;
    private Context context;
    private double expected;

    public NumberExpressionTest(double number, double expected) {
        this.context = new Context();
        numberExpression = new NumberExpression(number);
        this.expected = expected;



    }

    @Test
    public void shouldReturnCorrectNumber(){
        numberExpression.interpret(context);
        double result = context.popValue();
        Assert.assertEquals(expected,result,0.01);

    }

}
