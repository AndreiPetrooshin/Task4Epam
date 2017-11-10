package com.andreipetrushin.task4.composite;



public class ExpressionComponent implements Component {

    private String value;

    public ExpressionComponent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Component get(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Component component) {
        throw new UnsupportedOperationException();
    }

}
