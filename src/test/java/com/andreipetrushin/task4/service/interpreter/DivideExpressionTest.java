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
public class DivideExpressionTest {

    private static final Logger LOGGER = LogManager.getLogger(DivideExpressionTest.class);
    private static DivideExpression divideExpression = new DivideExpression();
    private Context context;
    private double expected;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {100,0,Double.POSITIVE_INFINITY},
                {-100,0,Double.NEGATIVE_INFINITY},
                {100,5,20},
                {100,3,33.333},
                {40.5,5.4,7.5},
                {0,-100,-0},
                {0,100,0},
                {0,0,Double.NaN},
        });
    }


    public DivideExpressionTest (double firstNumber, double secondNumber, double expected) {
        LOGGER.info("Coming values: firstNumber - {}, secondNumber - {}, expected - {}"
                ,firstNumber,secondNumber,expected);
        this.context = new Context();
        context.pushValue(firstNumber);
        context.pushValue(secondNumber);
        this.expected = expected;



    }

    @Test
    public void shouldDivideTheFirstNumberToSecondAndReturnResult(){
        divideExpression.interpret(context);
        double result = context.popValue();
        Assert.assertEquals(expected,result,0.01);

    }


}
