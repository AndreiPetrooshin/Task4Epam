package com.andreipetrushin.task4.parsers;

import com.andreipetrushin.task4.composite.Component;
import com.andreipetrushin.task4.composite.ExpressionComponent;
import com.andreipetrushin.task4.composite.ParagraphComposite;
import com.andreipetrushin.task4.composite.SentenceComposite;
import com.andreipetrushin.task4.entity.ExpressionEntity;
import com.andreipetrushin.task4.entity.SentenceEntity;

import java.io.File;

public class SentenceParser extends AbstractParser {

    private WordParser wordParser = new WordParser();
    private ExpressionParser expressionParser = new ExpressionParser();
    private File file;

    public SentenceParser() {
    }

    public SentenceParser(File file) {
        this.file = file;
    }

    @Override
    public Component parse(Component component) {
        if(wordParser !=null){
            wordParser.parse(component);
        }
        if(expressionParser!=null){
            expressionParser.parse(component);
        }
        ParagraphComposite paragraphComposite = new ParagraphComposite();
        paragraphComposite.push(new SentenceComposite(
                new SentenceEntity("It is a long established fact that a reader will be distracted by the readable")));
        return paragraphComposite;
    }
}
