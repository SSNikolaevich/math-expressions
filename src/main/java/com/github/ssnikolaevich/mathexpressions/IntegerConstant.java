package com.github.ssnikolaevich.mathexpressions;

public class IntegerConstant extends Expression {
    private int value;

    public IntegerConstant(int value) {
        super((value < 0) ? Presedences.SIGN : Presedences.CONSTANT);
        this.value = value;
    }

    @Override
    public String asString() {
        return Integer.toString(value);
    }

    @Override
    public float calculate() {
        return value;
    }
}

