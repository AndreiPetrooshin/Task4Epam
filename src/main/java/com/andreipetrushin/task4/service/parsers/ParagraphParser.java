package com.andreipetrushin.task4.service.parsers;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class ParagraphParser extends AbstractParser{

    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class);

    @Override
    protected List<String> parse(String text) {
        LOGGER.info("Coming text: {}", text);
        List<String> list = new ArrayList<>();
        Matcher matcher = PARAGRAPH_SPLITTER.matcher(text);
        LOGGER.info("Find paragraphs in our text by matcher,", matcher.toString());
        while(matcher.find()){
            String value = matcher.group().trim();
            list.add(value);
            LOGGER.info("Getting the value - \"{}\" from text and adding to list: {}", value,list);
        }
        return list;
    }
}
