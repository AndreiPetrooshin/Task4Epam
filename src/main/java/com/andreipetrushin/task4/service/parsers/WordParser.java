package com.andreipetrushin.task4.service.parsers;


import com.andreipetrushin.task4.composite.Component;
import com.andreipetrushin.task4.composite.SentenceComposite;
import com.andreipetrushin.task4.composite.WordComponent;

import java.util.List;

public class WordParser extends AbstractParser {

    private AbstractParser successor= null;

    @Override
    public Component handleRequest(String text, int j, int i) {
        List<String> list = parse(text,j,i);

        if(list.size() == 0){
            return  null;
        }

        Component component = new SentenceComposite();
        WordComponent wordComponent;
        for (int k = 0; k < list.size(); k++) {
            String value = list.get(k);
            wordComponent = new WordComponent(value);
            component.add(wordComponent);
        }
        return component;

    }

    @Override
    public List<String> parse(String text, int i, int j) {
        return null;

    }
}
