package com.andreipetrushin.task4.service.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class TerminalParser extends AbstractParser {

    private int i;
    private int j;

    public TerminalParser(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    protected List<String> parse(String text) {
        String correctString = replaceAllIadnJ(text);
        List<String> list = new ArrayList<>();
        Matcher matcher = WORD_SPLITTER.matcher(correctString);
        while (matcher.find()){
            String value = matcher.group().trim();
            list.add(value);
        }
        return list;
    }

    private String replaceAllIadnJ(String text) {
        text = text.replaceAll("(--j)|(j--)", String.valueOf(j-1));
        text =  text.replaceAll("(i--)|(--i)", String.valueOf(i-1));

        text = text.replaceAll("(\\+\\+j)|(j\\+\\+)", String.valueOf(j+1));
        text =  text.replaceAll("(i\\+\\+)|(\\+\\+i)", String.valueOf(i+1));


        return text;
    }
}
