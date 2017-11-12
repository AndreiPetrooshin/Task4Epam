package com.andreipetrushin.task4.service.parsers;

import com.andreipetrushin.task4.entity.Component;
import com.andreipetrushin.task4.entity.Composite;
import com.andreipetrushin.task4.entity.SimpleComponent;

import java.util.List;
import java.util.regex.Pattern;

public abstract class AbstractParser {


    private AbstractParser successor = null;


    static final Pattern PARAGRAPH_SPLITTER = Pattern.compile("(\\n?.+\\n?)");
    static final Pattern SENTENCE_SPLITTER = Pattern.compile("([A-Z](|[^?!.(]|\\([^)]*\\))*[.?!])");
    static final Pattern WORD_SPLITTER = Pattern.compile("([(]*[A-Za-z]+[).',:]*|-)|([-* ]+[+\\d\\-*/]+[-+*/\\d ]+)+");




    public void setSuccessor(AbstractParser successor) {
        this.successor = successor;
    }

    public  Component handleRequest(String text){
        List<String> list = parse(text);
        Component composite = new Composite();

        for(String value: list){
            if(successor!=null){
                Component component = successor.handleRequest(value);
                composite.add(component);
            } else {
                Component component = new SimpleComponent(value);
                composite.add(component);
            }
        }
        return composite;


    }

    protected abstract List<String> parse(String text);


}
