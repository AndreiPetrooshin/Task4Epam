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
public class ParseExpressionTest {

    private static final Logger LOGGER  = LogManager.getLogger(ParseExpressionTest.class);
    private ParseExpression parseExpression;
    private double expected;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {"4 3 + ",7},
                {"5 5 5 / +",6},
                {"10 5 *",50},
                {"5 10 -",-5},
                {"5 1 2 * 3 4 5 4 - 4 + * 3 - * 2 - * 1 - *",485},
                {"5 20 4 / 3 40 20 / 50 + * + 100 5 4 20 30 40 - * * + * - *",398305},
                {"0 0 /", Double.NaN},
                {"100 0 /", Double.POSITIVE_INFINITY},
                {"0 100 - 0 /", Double.NEGATIVE_INFINITY},
                {"5 5 / 20 5 / 100 * +",401},
        });
    }


    public ParseExpressionTest(String expression, double expected) {
            LOGGER.info("Coming values: expression - {}, expected value: {}", expression,expected);
            parseExpression = new ParseExpression(expression);
            this.expected = expected;



    }
    @Test
    public void shouldAddTheFirstNumberToSecondAndReturnResult(){
        double result = parseExpression.calculate();
        Assert.assertEquals(expected,result,0.01);

    }

}
