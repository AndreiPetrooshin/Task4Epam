package com.andreipetrushin.task4.service.interpreter;

import java.util.Deque;
import java.util.LinkedList;


public class Context {
        private Deque<Double> deque = new LinkedList<>();

        public Double popValue(){
            return  deque.pop();
        }

        public void pushValue(Double value){
            this.deque.push(value);
        }
}
