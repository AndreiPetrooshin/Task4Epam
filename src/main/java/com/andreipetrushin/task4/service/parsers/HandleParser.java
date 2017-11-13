package com.andreipetrushin.task4.service.parsers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HandleParser {

    private static final Logger LOGGER = LogManager.getLogger(HandleParser.class);
    private static AbstractParser instance;

    private HandleParser(){

    }

    public static AbstractParser getParserInstance(int i, int j){
        if(instance==null){

            ParagraphParser paragraphParser = new ParagraphParser();
            SentenceParser sentenceParser =new SentenceParser();
            TerminalParser wordParser = new TerminalParser(i,j);
            sentenceParser.setSuccessor(wordParser);
            paragraphParser.setSuccessor(sentenceParser);
            instance = paragraphParser;
            LOGGER.info("Creates the Parser: {}",instance );
        }
        return instance;
    }



}