package com.andreipetrushin.task4.service.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MinusExpressionTest {

    private static final Logger LOGGER = LogManager.getLogger(MinusExpressionTest.class);

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {10,5,5},
                {1600.100,600.100,1000},
                {-100,1000,-1100},
                {-5,0,-5},
                {0,0,0},
        });
    }

    private static MinusExpression minusExpression = new MinusExpression();
    private Context context;
    private double expected;

    public MinusExpressionTest(double firstNumber, double secondNumber, double expected) {
        LOGGER.info("Coming values: firstNumber - {}, secondNumber - {}, expected - {}"
                ,firstNumber,secondNumber,expected);
        this.context = new Context();
        context.pushValue(firstNumber);
        context.pushValue(secondNumber);
        this.expected = expected;



    }

    @Test
    public void shouldMinusTheFirstNumberToSecondAndReturnResult(){
        minusExpression.interpret(context);
        double result = context.popValue();
        Assert.assertEquals(expected,result,0.01);

    }

}
