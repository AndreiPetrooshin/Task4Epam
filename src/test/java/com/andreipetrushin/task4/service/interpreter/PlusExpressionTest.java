package com.andreipetrushin.task4.service.interpreter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PlusExpressionTest {

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
            {5.2,3,8.2},
            {1422.1,3231.4,4653.5},
            {-100.5,300,199.5},
            {-5,0,-5},
            {0,5,5},
        });
    }

    private PlusExpression plusExpression = new PlusExpression();
    private Context context;
    private double expected;

    public PlusExpressionTest(double firstNumber, double secondNumber, double expected) {
        this.context = new Context();
        context.pushValue(firstNumber);
        context.pushValue(secondNumber);
        this.expected = expected;



    }

    @Test
    public void shouldAddTheFirstNumberToSecondAndReturnResult(){
        plusExpression.interpret(context);
        double result = context.popValue();
        Assert.assertEquals(expected,result,0.01);

    }

}
