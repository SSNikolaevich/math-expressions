package com.github.ssnikolaevich.mathexpressions;

public abstract class Expression {
    private int precedence;

    public Expression(int precedence) {
        this.precedence = precedence;
    }

    public int getPrecedence() {
        return precedence;
    }

    public abstract String asString();
    public abstract float calculate();
}
