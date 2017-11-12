package com.andreipetrushin.task4.service.interpreter;

import java.util.ArrayList;
import java.util.Scanner;

public class ParseExpression {

    private ArrayList<AbstractExpression> list;

    public ParseExpression(String expression) {
        list = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    list.add(new PlusExpression());
                    break;
                case '-':
                    list.add(new MinusExpression());
                    break;
                case '/':
                    list.add(new DivideExpression());
                    break;
                case '*':
                    list.add(new MultiplyExpression());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        list.add(new NumberExpression(scanner.nextInt()));
                    }
            }
        }
    }

    public double calculate(){
        Context context = new Context();
        for(AbstractExpression terminal: list){
            terminal.interpret(context);
        }
        return context.popValue();
    }

}

