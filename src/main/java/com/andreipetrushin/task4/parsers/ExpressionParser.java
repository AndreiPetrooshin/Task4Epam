package com.andreipetrushin.task4.parsers;

import com.andreipetrushin.task4.composite.Component;
import com.andreipetrushin.task4.composite.ExpressionComponent;
import com.andreipetrushin.task4.composite.SentenceComposite;
import com.andreipetrushin.task4.composite.WordComponent;
import com.andreipetrushin.task4.entity.ExpressionEntity;
import com.andreipetrushin.task4.entity.WordEntity;

import java.io.File;

public class ExpressionParser extends AbstractParser {

    private AbstractParser parser = null;
    private File file;

    public ExpressionParser(File file) {
        this.file = file;
    }

    public ExpressionParser() {
    }

    @Override
    public Component parse(Component component) {
        if(parser!=null){
            parser.parse(component);
        }
        SentenceComposite sentenceComposite = new SentenceComposite();
        sentenceComposite.push(new ExpressionComponent(new ExpressionEntity("4")));
        return sentenceComposite;
    }
}
