package com.andreipetrushin.task4.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileTextReader {

    private static final Logger LOGGER = LogManager.getLogger(FileTextReader.class);

    public static String read(String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        LOGGER.debug("Coming path - {}",path);
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {

        while(reader.ready()){
                int c = reader.read();
                builder.append((char)c);

            }
        }
        LOGGER.debug("Read text: {}", builder);
        return builder.toString();
    }

}
