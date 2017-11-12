package com.andreipetrushin.task4.service.parsers;



public class HandleParser {

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
        }
        return instance;
    }



}