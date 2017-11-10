package com.andreipetrushin.task4.service.parsers;

import com.andreipetrushin.task4.composite.Component;
import com.andreipetrushin.task4.composite.ParagraphComposite;
import com.andreipetrushin.task4.composite.SentenceComposite;
import com.andreipetrushin.task4.entity.ExpressionEntity;
import com.andreipetrushin.task4.entity.ParagraphEntity;
import com.andreipetrushin.task4.entity.SentenceEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SentenceParserTest {

    private static final String TEXT = "Lorem Ipsum passages, and more recently with desktop publishing software\n" +
            "like Aldus PageMaker including version of Loren Ipsum.\n" +
            "\n" +
            "    It is a long established fact that a reader will be distracted by the readable";
    public static final String TEXT_RESULT = "It is a long established fact that a reader will be distracted by the readable";

    private SentenceParser sentenceParser;

    private ParagraphComposite paragraphComposite;
    private ParagraphEntity paragraphEntity;

    private SentenceComposite sentenceComposite;
    private SentenceEntity sentenceEntity;


    @Before
    public void initBeforeCallMethod(){
        sentenceParser = new SentenceParser();

        paragraphEntity = new ParagraphEntity(TEXT);
        paragraphComposite = new ParagraphComposite(paragraphEntity);

        sentenceEntity = new SentenceEntity(TEXT_RESULT);
        sentenceComposite = new SentenceComposite(sentenceEntity);

    }

    @Test
    public void shouldParseSentenceCompositeIntoWords(){
        Component result =  sentenceParser.parse(paragraphComposite);
        Assert.assertEquals(sentenceComposite, result.get());
    }
}
