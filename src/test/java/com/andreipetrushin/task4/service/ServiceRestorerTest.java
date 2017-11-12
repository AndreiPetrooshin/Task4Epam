package com.andreipetrushin.task4.service;

import com.andreipetrushin.task4.entity.Component;
import com.andreipetrushin.task4.reader.FileTextReader;
import com.andreipetrushin.task4.service.parsers.AbstractParser;
import com.andreipetrushin.task4.service.parsers.HandleParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ServiceRestorerTest {

    private static final int I = 5;
    private static final int J = 4;
    private static final AbstractParser abstractParser = HandleParser.getParserInstance(I,J);
    private static String TEXT;

    static{
        try {
            TEXT = FileTextReader.read("./src/main/resources/easyTest");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final StringBuilder EXPECTED = new StringBuilder("It has survived - not only (five) centuries, but also the leap into 17.0 electronic typesetting. " +
            "\nIt is a -600.0 established fact.\n");

    @Test
    public void shouldParseTextAndReturnCompositeWithCalculatedText(){
        Component componentResult = abstractParser.handleRequest(TEXT);
        StringBuilder builderResult = ServiceRestorer.restore(componentResult);
        Assert.assertEquals(EXPECTED.toString().trim(),builderResult.toString().trim());

    }


}
