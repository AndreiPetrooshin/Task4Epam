package com.andreipetrushin.task4.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FileTextReaderTest {

    private static final Logger LOGGER = LogManager.getLogger(FileTextReaderTest.class);
    private static final String CORRECT_PATH = "./src/main/resources/simpleText";
    private static final String ERROR_PATH = ".src/main/resources/noSuchFile";
    private static final String EXPECTED_TEXT = "It has survived - not only (five) centuries, but also the leap into 13 i-- +" +
            " electronic typesetting. It is a 0 5 - 1 2 / 2 5 2 * + --j - * + 1200 * established fact.";

    @Test
    public void shouldReturnTextWhenPathIsCorrect(){
        try {
            String result = FileTextReader.read(CORRECT_PATH);
            Assert.assertEquals(EXPECTED_TEXT,result);
        } catch (IOException e) {
            LOGGER.error("Bad path to file - {}", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(expected = IOException.class)
    public void shouldThrowExceptionWhenPathIsError() throws IOException {
        FileTextReader.read(ERROR_PATH);
    }


}
