package com.andreipetrushin.task4.service.interpreter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class ContextTest {

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {10.5,20, 40 , 30.1, 50},
                {30,-40,100,4000231,100000000},
                {-55222222,100,0,0,30},
        });
    }

    private Context context;
    private List<Double> expectedList;
    private List<Double> resultList;

    public ContextTest(double n1, double n2, double n3, double n4, double n5) {
        this.context = new Context();
        context.pushValue(n1);
        context.pushValue(n2);
        context.pushValue(n3);
        context.pushValue(n4);
        context.pushValue(n5);
        expectedList = Arrays.asList(n1,n2,n3,n4,n5);



    }

    @Test
    public void shouldReturnCorrectCountOfNumbersAndValues(){
        resultList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            resultList.add(context.popValue());
        }
        Collections.reverse(resultList);
        Assert.assertEquals(expectedList,resultList);

    }

}
