package com.andreipetrushin.task4.service.parsers;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class SentenceParser extends AbstractParser {

    private static final Logger LOGGER = LogManager.getLogger(SentenceParser.class);

    @Override
    protected List<String> parse(String text) {
        LOGGER.info("Coming text: {}", text);
        List<String> list = new ArrayList<>();
        Matcher matcher = SENTENCE_SPLITTER.matcher(text);
        LOGGER.info("Find sentences in our text by matcher,", matcher.toString());
        while (matcher.find()){
            String value = matcher.group(1).trim();
            list.add(value);
            LOGGER.debug("Getting the value - \"{}\" from text and adding to list: {}", value,list);
        }
        return list;

    }
}
