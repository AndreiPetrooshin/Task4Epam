package com.andreipetrushin.task4.service.parsers;

import com.andreipetrushin.task4.entity.Component;
import com.andreipetrushin.task4.entity.Composite;
import com.andreipetrushin.task4.entity.SimpleComponent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TerminalParserTEst {

    private static final List<String> EXPECTED  = Arrays.asList(
            "Leap", "13 9 +", "Remaining","essentially", "20 19 -", "Bye.");
    private static final String TEXT = "Leap 13 i-- + Remaining essentially 20 j-- - Bye.";
    private static final TerminalParser parser = new TerminalParser(10,20);


    @Test
    public void shouldParseSentenceToTerminal(){
        List<String> result = parser.parse(TEXT);
        Assert.assertEquals(EXPECTED, result);

    }


    @Test
    public void shouldReturnCorrectComposite(){
        Component result = parser.handleRequest(TEXT);
        Component expectedComponent  = new Composite();
        for(String value: EXPECTED){
            SimpleComponent component = new SimpleComponent(value);
            expectedComponent.add(component);
        }
        Assert.assertEquals(expectedComponent,result);
    }


}
