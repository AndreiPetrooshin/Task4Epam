package com.andreipetrushin.task4.service.parsers;


import com.andreipetrushin.task4.composite.Component;
import com.andreipetrushin.task4.composite.ParagraphComposite;
import java.util.List;

public class ParagraphParser extends AbstractParser{

    private SentenceParser sentenceParser= new SentenceParser();

    @Override
    public Component handleRequest(String text, int j, int i) {

        List<String> list = parse(text,i,j);

        ParagraphComposite composite = new ParagraphComposite();
        Component sentenceComposite;
        for (int k = 0; k < list.size(); k++) {
            String value = list.get(k);
            sentenceComposite = sentenceParser.handleRequest(value,i,j);
            composite.add(sentenceComposite);
        }
        return composite;
    }

    @Override
    protected List<String> parse(String text, int j, int i) {
        return null;
    }
}
