package com.andreipetrushin.task4.service.parsers;


import com.andreipetrushin.task4.entity.Component;
import com.andreipetrushin.task4.entity.Composite;
import com.andreipetrushin.task4.entity.SimpleComponent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParagraphParserTest {

    private static final String TEXT = "Someone said.\n" + "Two big 42+236+++j cars.\n" + "\nBye";
    private static final ParagraphParser parser= new ParagraphParser();
    private static final List<String> EXPECTED = Arrays.asList("Someone said.", "Two big 42+236+++j cars.", "Bye");


    @Test
    public void shouldParseTextToParagraphsAndReturnList() {
        List<String> result = parser.parse(TEXT);
        Assert.assertEquals(EXPECTED, result);
    }

    @Test
    public void shouldReturnCorrectComposite(){
       Component result = parser.handleRequest(TEXT);
       Component expectedComponent = new Composite();
        for(String value: EXPECTED){
            SimpleComponent component = new SimpleComponent(value);
            expectedComponent.add(component);
        }
        Assert.assertEquals(expectedComponent,result);

    }
}
