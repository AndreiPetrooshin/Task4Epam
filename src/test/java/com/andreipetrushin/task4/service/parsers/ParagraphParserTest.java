package com.andreipetrushin.task4.service.parsers;

import com.andreipetrushin.task4.composite.*;
import com.andreipetrushin.task4.entity.ParagraphEntity;
import com.andreipetrushin.task4.entity.TextEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParagraphParserTest {

    public static final String TEXT = "It has survived - not only (five) centuries, but also the leap into 13+ i--\n" +
            "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was\n" +
            "popularised in the 5*(1*2*(3*(4*(5- --j +4)-3)-2)-1 with the release of Letraset sheets\n" +
            "containing Lorem Ipsum passages, and more recently with desktop publishing software\n" +
            "like Aldus PageMaker including version of Loren Ipsum.\n" +
            "\n" +
            "    It is a long established fact that a reader will be distracted by the readable\n" +
            "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2(*2)-\n" +
            "2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution letters, as\n" +
            "opposed to using (Content here), content here', making it look like readable English.";
    public static final String TEXT_RESULT = "It is a long established fact that a reader will be distracted by the readable\n" +
            "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2(*2)-\n" +
            "2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution letters, as\n" +
            "opposed to using (Content here), content here', making it look like readable English.";

    private ParagraphParser paragraphParser;
    private TextComposite textComposite;
    private TextEntity textEntity;
    private ParagraphComposite paragraphComposite;
    private ParagraphEntity paragraphEntity;


    @Before
    public void initBeforeCallMethod(){
        paragraphParser = new ParagraphParser();

        textEntity = new TextEntity(TEXT);
        textComposite = new TextComposite(textEntity);

        paragraphEntity = new ParagraphEntity(TEXT_RESULT);
        paragraphComposite = new ParagraphComposite(paragraphEntity);

    }

    @Test
    public void shouldParseSentenceCompositeIntoWords(){
        Component result =  paragraphParser.parse(textComposite);
        Assert.assertEquals(paragraphComposite, result.get());
    }

}
