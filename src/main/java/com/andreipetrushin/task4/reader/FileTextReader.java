package com.andreipetrushin.task4.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileTextReader {

    public static String read(String path) throws IOException {
        StringBuilder builder = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {

        while(reader.ready()){
                int c = reader.read();
                builder.append((char)c);

            }
        }
        return builder.toString();
    }

}
