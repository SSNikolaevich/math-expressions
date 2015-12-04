package com.github.ssnikolaevich.mathexpressions;

public class Main {
    public static void main(String[] args) {
        ExpressionGenerator generator = new ExpressionGenerator();
        generator.setEnableMulDiv(true);
        Expression expression = generator.generate(2);
        System.out.printf("%s = %d\n", expression.asString(), Math.round(expression.calculate()));
    }
}
