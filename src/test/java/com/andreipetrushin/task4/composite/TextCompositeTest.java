package com.andreipetrushin.task4.composite;

import com.andreipetrushin.task4.entity.ParagraphEntity;
import com.andreipetrushin.task4.entity.TextEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextCompositeTest {

    private static final String VALUE = "It has survived - not only (five) centuries";
    private TextComposite composite = null;
    private ParagraphComposite paragraphCompositeFirst = null;
    private ParagraphComposite paragraphCompositeSecond = null;
    private ParagraphComposite paragraphCompositeThird = null;

    @Before
    public void initBeforeTests(){
        TextEntity textEntity = new TextEntity("It has survived - not only (five) centuries");
        composite = new TextComposite(textEntity);
        paragraphCompositeFirst = new ParagraphComposite(
                new ParagraphEntity("It was\n" +
                "popularised in the 5*(1*2*(3*(4*(5- --j +4)-3)-2)-1 with the release"));
        paragraphCompositeSecond = new ParagraphComposite(
                new ParagraphEntity(" It is a long established fact that a reader"));
        paragraphCompositeThird = new ParagraphComposite(
                new ParagraphEntity("Some text"));
        composite.push(paragraphCompositeFirst);
        composite.push(paragraphCompositeSecond);
    }

    @Test
    public void shouldReturnAndRemoveLastElement(){
        Component result = composite.pop();
        Assert.assertEquals(paragraphCompositeSecond, result);
        Component secondResult = composite.pop();
        Assert.assertEquals(paragraphCompositeFirst, secondResult);

    }

    @Test
    public void shouldRemoveElementAndReturnTrueIfSuccess(){
        boolean result = composite.remove(paragraphCompositeSecond);
        Component secondResult  = composite.pop();
        Assert.assertEquals(true,result);
        Assert.assertEquals(paragraphCompositeFirst,secondResult);
    }

    @Test
    public void shouldAddElementToList(){
        composite.push(paragraphCompositeThird);
        Component result= composite.pop();
        Assert.assertEquals(paragraphCompositeThird, result);
    }

    @Test
    public void shouldReturnEntityContent(){
        String result = composite.getEntityContent();
        Assert.assertEquals(VALUE, result);
    }





}
