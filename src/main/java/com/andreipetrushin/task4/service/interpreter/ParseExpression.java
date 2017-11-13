package com.andreipetrushin.task4.service.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class ParseExpression {

    private static final Logger LOGGER  = LogManager.getLogger(ParseExpression.class);
    private ArrayList<AbstractExpression> list;
    public ParseExpression(String expression) {
        LOGGER.info("Coming EXPRESSION : {}", expression);
        list = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            LOGGER.info("Check expression: " + lexeme + "; ExpressionList: " , list);
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    list.add(new PlusExpression());
                    LOGGER.info("Adding PlusExpression to our list: {} ", list);
                    break;
                case '-':
                    list.add(new MinusExpression());
                    LOGGER.info("Adding MinusExpression to our list: {} ", list);
                    break;
                case '/':
                    list.add(new DivideExpression());
                    LOGGER.info("Adding DivideExpression to our list: {} ", list);
                    break;
                case '*':
                    list.add(new MultiplyExpression());
                    LOGGER.info("Adding MultiplyExpression to our list: {} ", list);
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        list.add(new NumberExpression(scanner.nextInt()));
                        LOGGER.info("Adding NumberExpression to our list: {} ", list);
                    }
            }
        }
    }

    public double calculate(){
        LOGGER.info("Start of calculation: {}", list);
        Context context = new Context();
        for(AbstractExpression terminal: list){
            terminal.interpret(context);}
        LOGGER.info("End of calculation: {}", list);
        return context.popValue();
    }

}

