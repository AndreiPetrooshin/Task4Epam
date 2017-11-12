package com.andreipetrushin.task4.service.parsers;



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class SentenceParser extends AbstractParser {

    @Override
    protected List<String> parse(String text) {
        List<String> list = new ArrayList<>();
        Matcher matcher = SENTENCE_SPLITTER.matcher(text);
        while (matcher.find()){
            String value = matcher.group(1).trim();
            list.add(value);
        }
        return list;

    }
}
