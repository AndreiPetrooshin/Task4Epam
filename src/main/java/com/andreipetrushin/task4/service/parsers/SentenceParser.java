package com.andreipetrushin.task4.service.parsers;


import com.andreipetrushin.task4.composite.Component;
import com.andreipetrushin.task4.composite.SentenceComposite;

import java.util.List;

public class SentenceParser extends AbstractParser {

    private WordParser wordParser = new WordParser();
    private ExpressionParser expressionParser = new ExpressionParser();


    @Override
    public Component handleRequest(String text, int j, int i) {

        List<String> list = parse(text,i,j);

        SentenceComposite composite = new SentenceComposite();
        Component wordComponent;
        Component expressionComponent;
        for (int k = 0; k < list.size(); k++) {
            String value =  list.get(k);
            wordComponent = wordParser.handleRequest(value,i,j);
            expressionComponent = expressionParser.handleRequest(value,i,j);
            if(wordComponent!=null){
                composite.add(wordComponent);
            }
            if(expressionComponent!=null){
                composite.add(expressionComponent);
            }
        }
        return composite;

    }

    @Override
    protected List<String> parse(String text, int j, int i) {
        return null;
    }
}
