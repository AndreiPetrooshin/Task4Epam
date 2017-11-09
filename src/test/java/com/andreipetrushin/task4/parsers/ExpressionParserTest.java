package com.andreipetrushin.task4.parsers;

import com.andreipetrushin.task4.composite.Component;
import com.andreipetrushin.task4.composite.ExpressionComponent;
import com.andreipetrushin.task4.composite.SentenceComposite;
import com.andreipetrushin.task4.entity.ExpressionEntity;
import com.andreipetrushin.task4.entity.SentenceEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpressionParserTest {

    private ExpressionParser expressionParser;
    private SentenceComposite sentenceComposite;
    private SentenceEntity sentenceEntity;
    private ExpressionComponent expressionComponent;
    private ExpressionEntity expressionEntity;


    @Before
    public void initBeforeCallMethod(){
        expressionParser = new ExpressionParser();

        sentenceEntity = new SentenceEntity("1+5-2");
        sentenceComposite = new SentenceComposite(sentenceEntity);

        expressionEntity = new ExpressionEntity("4");
        expressionComponent = new ExpressionComponent(expressionEntity);

    }

    @Test
    public void shouldParseSentenceCompositeIntoWords(){
        Component result =  expressionParser.parse(sentenceComposite);
        Assert.assertEquals(expressionComponent, result.pop());
    }
}
