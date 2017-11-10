package com.andreipetrushin.task4.composite;

import com.andreipetrushin.task4.entity.ExpressionEntity;
import com.andreipetrushin.task4.entity.SentenceEntity;
import com.andreipetrushin.task4.entity.WordEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SentenceCompositeTest {


    private static final String VALUE = "It has survived - not only (five) centuries";
    private SentenceComposite composite = null;
    private WordComponent wordComponentFirst = null;
    private WordComponent wordComponentSecond = null;
    private ExpressionComponent expressionComponent = null;

    @Before
    public void initBeforeTests(){
        SentenceEntity paragraphEntity = new SentenceEntity("It has survived - not only (five) centuries");
        composite = new SentenceComposite(paragraphEntity);
        wordComponentFirst = new WordComponent(
                new WordEntity("was"));
        wordComponentSecond = new WordComponent(
                new WordEntity("reader"));
        expressionComponent = new ExpressionComponent(
                new ExpressionEntity("6+9*(3-4)"));
        composite.add(wordComponentFirst);
        composite.add(wordComponentSecond);
    }

    @Test
    public void shouldReturnAndRemoveLastElement(){
        Component result = composite.get();
        Assert.assertEquals(wordComponentSecond, result);
        Component secondResult = composite.get();
        Assert.assertEquals(wordComponentFirst, secondResult);

    }

    @Test
    public void shouldRemoveElementAndReturnTrueIfSuccess(){
        boolean result = composite.remove(wordComponentSecond);
        Component secondResult  = composite.get();
        Assert.assertEquals(true,result);
        Assert.assertEquals(wordComponentFirst,secondResult);
    }

    @Test
    public void shouldAddElementToList(){
        composite.add(expressionComponent);
        Component result= composite.get();
        Assert.assertEquals(expressionComponent, result);
    }

    @Test
    public void shouldReturnEntityContent(){
        String result = composite.getEntityContent();
        Assert.assertEquals(VALUE, result);
    }



}
