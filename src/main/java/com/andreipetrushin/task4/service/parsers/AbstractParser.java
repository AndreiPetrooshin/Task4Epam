package com.andreipetrushin.task4.service.parsers;

import com.andreipetrushin.task4.entity.Component;
import com.andreipetrushin.task4.entity.Composite;
import com.andreipetrushin.task4.entity.SimpleComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Pattern;

public abstract class AbstractParser {


    private AbstractParser successor = null;


    static final Pattern PARAGRAPH_SPLITTER = Pattern.compile("(\\n?.+\\n?)");
    static final Pattern SENTENCE_SPLITTER = Pattern.compile("([A-Z](|[^?!.(]|\\([^)]*\\))*[.?!])");
    static final Pattern WORD_SPLITTER = Pattern.compile("([(]*[A-Za-z]+[).',:]*|-)|([-* ]+[+\\d\\-*/]+[-+*/\\d ]+)+");
    private static final Logger LOGGER = LogManager.getLogger(AbstractParser.class);




    public void setSuccessor(AbstractParser successor) {
        this.successor = successor;
    }

    public  Component handleRequest(String text){
        LOGGER.info("Coming text - {}", text);
        List<String> list = parse(text);
        LOGGER.info("Text after parse() - {}", list);
        Component composite = new Composite();

        for(String value: list){
            if(successor!=null){
                LOGGER.info("Calling handleRequest() in our successor - {}", successor);
                Component component = successor.handleRequest(value);
                LOGGER.info("Adding component: {} to out composite: {}", component,composite);
                composite.add(component);
                LOGGER.info("After adding component to composite: {}",composite);
            } else {
                LOGGER.info("When successor == null, create new SimpleComponent with value - {} ", value);
                Component component = new SimpleComponent(value);
                LOGGER.info("Adding component: {} to out composite: {}", component,composite);
                composite.add(component);
                LOGGER.info("After adding component to composite: {}",composite);
            }
        }
        LOGGER.info("Final composite: {}", composite);
        return composite;


    }

    protected abstract List<String> parse(String text);


}
