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
public class MultiplyExpressionTest {

    private static final Logger LOGGER = LogManager.getLogger(MultiplyExpression.class);

    private static MultiplyExpression multiplyExpression = new MultiplyExpression();

    private Context context;
    private double expected;

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

    public MultiplyExpressionTest (double firstNumber, double secondNumber, double expected) {
        LOGGER.info("Coming values: firstNumber -{}, secondNumber - {}, expected - {}"
                ,firstNumber,secondNumber,expected);
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
