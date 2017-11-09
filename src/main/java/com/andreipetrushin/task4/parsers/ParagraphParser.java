package com.andreipetrushin.task4.parsers;

import com.andreipetrushin.task4.composite.*;
import com.andreipetrushin.task4.entity.ParagraphEntity;
import com.andreipetrushin.task4.entity.SentenceEntity;

import java.io.File;

public class ParagraphParser extends AbstractParser{

    private File file = null ;
    private SentenceParser sentenceParser= new SentenceParser();

    public ParagraphParser() {
    }

    public ParagraphParser(File file) {
        this.file = file;
    }


    @Override
    public Component parse(Component component) {
        if(sentenceParser!=null){
            sentenceParser.parse(component);
        }
        TextComposite textComposite = new TextComposite();
        textComposite.push(new ParagraphComposite(
                new ParagraphEntity("It is a long established fact that a reader will be distracted by the readable\n" +
                        "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2(*2)-\n" +
                        "2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution letters, as\n" +
                        "opposed to using (Content here), content here', making it look like readable English.")));
        return textComposite;
    }
}
