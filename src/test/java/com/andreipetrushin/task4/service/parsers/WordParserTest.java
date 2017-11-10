package com.andreipetrushin.task4.service.parsers;


import com.andreipetrushin.task4.composite.Component;
import com.andreipetrushin.task4.composite.SentenceComposite;
import com.andreipetrushin.task4.composite.WordComponent;
import com.andreipetrushin.task4.entity.SentenceEntity;
import com.andreipetrushin.task4.entity.WordEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordParserTest {

    private WordParser wordParser;
    private SentenceComposite sentenceComposite;
    private SentenceEntity sentenceEntity;
    private WordComponent wordComponent;
    private WordEntity wordEntity;


    @Before
    public void initBeforeCallMethod(){
        wordParser = new WordParser();

        sentenceEntity = new SentenceEntity("Hello world!");
        sentenceComposite = new SentenceComposite(sentenceEntity);

        wordEntity = new WordEntity("world!");
        wordComponent = new WordComponent(wordEntity);

    }

    @Test
    public void shouldParseSentenceCompositeIntoWords(){
      Component result =  wordParser.parse(sentenceComposite);
        Assert.assertEquals(wordComponent, result.get());
    }

}
