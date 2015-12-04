package com.github.ssnikolaevich.mathexpressions;

public class MathOperators {
    public static Expression add(Expression first, Expression second) {
        BinaryOperator.Operator operator = new BinaryOperator.Operator() {
            @Override
            public float apply(float _1, float _2) { return _1 + _2; }
        };
        return new BinaryOperator(Presedences.ADDSUB, first, second, "+", operator);
    }

    public static Expression sub(Expression first, Expression second) {
        BinaryOperator.Operator operator = new BinaryOperator.Operator() {
            @Override
            public float apply(float _1, float _2) { return _1 - _2; }
        };
        return new BinaryOperator(Presedences.ADDSUB, first, second, "-", operator);
    }

    public static Expression mul(Expression first, Expression second) {
        BinaryOperator.Operator operator = new BinaryOperator.Operator() {
            @Override
            public float apply(float _1, float _2) { return _1 * _2; }
        };
        return new BinaryOperator(Presedences.MULDIV, first, second, "\u00B7", operator);
    }

    public static Expression div(Expression first, Expression second) {
        BinaryOperator.Operator operator = new BinaryOperator.Operator() {
            @Override
            public float apply(float _1, float _2) { return _1 / _2; }
        };
        return new BinaryOperator(Presedences.MULDIV, first, second, ":", operator);
    }
}
