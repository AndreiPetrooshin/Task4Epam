package com.andreipetrushin.task4.service.parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class TerminalParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);
    private int i;
    private int j;

    public TerminalParser(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    protected List<String> parse(String text) {
        LOGGER.info("Coming text: {}", text);
        LOGGER.info("Calling replaceAllIAndJ");
        String correctString = replaceAllIAdnJ(text);
        List<String> list = new ArrayList<>();
        Matcher matcher = WORD_SPLITTER.matcher(correctString);
        LOGGER.info("Find terminal literals in our text by matcher,", matcher.toString());
        while (matcher.find()){
            String value = matcher.group().trim();
            list.add(value);
            LOGGER.info("Getting the value - \"{}\"; from text and adding to list: {}", value,list);
        }
        return list;
    }

    private String replaceAllIAdnJ(String text) {
        LOGGER.info("Replacing all i and j value to:{},{}; in text:{}", i,j, text);
        text = text.replaceAll("(--j)|(j--)", String.valueOf(j-1));
        text =  text.replaceAll("(i--)|(--i)", String.valueOf(i-1));

        text = text.replaceAll("(\\+\\+j)|(j\\+\\+)", String.valueOf(j+1));
        text =  text.replaceAll("(i\\+\\+)|(\\+\\+i)", String.valueOf(i+1));

        LOGGER.info("Result after replacing: {}", text);

        return text;
    }
}
