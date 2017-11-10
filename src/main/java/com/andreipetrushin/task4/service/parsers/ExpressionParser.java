package com.andreipetrushin.task4.service.parsers;

import com.andreipetrushin.task4.composite.Component;
import com.andreipetrushin.task4.composite.ExpressionComponent;
import com.andreipetrushin.task4.composite.SentenceComposite;

import java.util.List;

public class ExpressionParser extends AbstractParser {

    private AbstractParser successor = null;


    @Override
    public Component handleRequest(String text, int j, int i) {
        List<String> list = parse(text,j,i);

        if(list.size() == 0){
            return  null;
        }

        Component component = new SentenceComposite();
        ExpressionComponent expressionComponent;
        for (int k = 0; k < list.size(); k++) {
            String value = list.get(k);
            expressionComponent = new ExpressionComponent(value);
            component.add(expressionComponent);
        }
        return component;
    }

    @Override
    protected List<String> parse(String text, int j, int i) {
        return null;
    }
}
