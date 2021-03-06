package com.andreipetrushin.task4.service.parsers;


import com.andreipetrushin.task4.entity.Component;
import com.andreipetrushin.task4.entity.Composite;
import com.andreipetrushin.task4.entity.SimpleComponent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SentenceParserTest {

    private static final SentenceParser parser = new SentenceParser();
    private static final List<String> EXPECTED  = Arrays.asList(
            "Leap 13+i-- typesetting.", "Remaining 3+5, essentially 6+9*(3-4).", "Bye.");
    public static final String TEXT = "Leap 13+i-- typesetting. Remaining 3+5, essentially 6+9*(3-4). Bye.";


    @Test
    public void shouldParseParagraphsToSentences(){
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
