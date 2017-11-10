package com.andreipetrushin.task4.composite;

import com.andreipetrushin.task4.entity.ParagraphEntity;
import com.andreipetrushin.task4.entity.SentenceEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParagraphCompositeTest {

    private static final String VALUE = "It has survived - not only (five) centuries";
    private ParagraphComposite composite = null;
    private SentenceComposite sentenceCompositeFirst = null;
    private SentenceComposite sentenceCompositeSecond = null;
    private SentenceComposite sentenceCompositeThird = null;

    @Before
    public void initBeforeTests(){
        ParagraphEntity paragraphEntity = new ParagraphEntity("It has survived - not only (five) centuries");
        composite = new ParagraphComposite(paragraphEntity);
        sentenceCompositeFirst = new SentenceComposite(
                new SentenceEntity("It was\n" +
                        "popularised in the 5*(1*2*(3*(4*(5- --j +4)-3)-2)-1 with the release"));
        sentenceCompositeSecond = new SentenceComposite(
                new SentenceEntity(" It is a long established fact that a reader"));
        sentenceCompositeThird = new SentenceComposite(
                new SentenceEntity("Some text"));
        composite.add(sentenceCompositeFirst);
        composite.add(sentenceCompositeSecond);
    }

    @Test
    public void shouldReturnAndRemoveLastElement(){
        Component result = composite.get();
        Assert.assertEquals(sentenceCompositeSecond, result);
        Component secondResult = composite.get();
        Assert.assertEquals(sentenceCompositeFirst, secondResult);

    }

    @Test
    public void shouldRemoveElementAndReturnTrueIfSuccess(){
        boolean result = composite.remove(sentenceCompositeSecond);
        Component secondResult  = composite.get();
        Assert.assertEquals(true,result);
        Assert.assertEquals(sentenceCompositeFirst,secondResult);
    }

    @Test
    public void shouldAddElementToList(){
        composite.add(sentenceCompositeThird);
        Component result= composite.get();
        Assert.assertEquals(sentenceCompositeThird, result);
    }

    @Test
    public void shouldReturnEntityContent(){
        String result = composite.getEntityContent();
        Assert.assertEquals(VALUE, result);
    }


}
