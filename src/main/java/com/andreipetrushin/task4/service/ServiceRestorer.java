package com.andreipetrushin.task4.service;

import com.andreipetrushin.task4.entity.Component;
import com.andreipetrushin.task4.service.interpreter.ParseExpression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Pattern;

public class ServiceRestorer {

    private static final Pattern EXPRESSION_SPLITTER = Pattern.compile("([-* ]+[+\\d\\-*/]+[-+*/\\d ]+)+");
    private static final Logger LOGGER = LogManager.getLogger(ServiceRestorer.class);

    public static StringBuilder restore(Component component) {
        LOGGER.info("Coming component: {}", component);
        StringBuilder builder = new StringBuilder();
        List<Component> paragraphList = component.getAll();
        for(Component paragraph: paragraphList){
            List<Component> sentenceList = paragraph.getAll();
            for(Component sentence: sentenceList){
                List<Component> terminalList = sentence.getAll();
                for(Component terminal: terminalList){
                    String value = terminal.getValue();
                    if(EXPRESSION_SPLITTER.matcher(value).find()){
                        ParseExpression expression = new ParseExpression(value);
                        double number = expression.calculate();
                        value = String.valueOf(number);
                    }
                    builder.append(value);
                    builder.append(" ");
                }
                builder.append('\n');
            }
        }
        LOGGER.info("The String from component after restore: {}", builder);
        return builder;
    }

}
