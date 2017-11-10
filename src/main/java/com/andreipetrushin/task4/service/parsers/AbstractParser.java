package com.andreipetrushin.task4.service.parsers;

import com.andreipetrushin.task4.composite.Component;

import java.util.List;

public abstract class AbstractParser {

    AbstractParser successor = null;

    public abstract Component handleRequest(String text, int j, int i);

    protected  abstract List<String> parse(String text, int j, int i);

}
