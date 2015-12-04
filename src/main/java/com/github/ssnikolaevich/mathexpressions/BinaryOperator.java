package com.github.ssnikolaevich.mathexpressions;

public class BinaryOperator extends Expression {
    private Expression first;
    private Expression second;
    private String symbol;

    public interface Operator {
        float apply(float first, float second);
    };

    private Operator operator;

    public BinaryOperator(int precedence, Expression first, Expression second, String symbol, Operator operator) {
        super(precedence);
        this.first = first;
        this.second = second;
        this.symbol = symbol;
        this.operator = operator;
    }

    private String operandAsString(Expression expression) {
        int expressionPrecedence = expression.getPrecedence();
        String template = ((expressionPrecedence > Presedences.CONSTANT)
                && (getPrecedence() > expressionPrecedence))? "(%s)" : "%s";
        return String.format(template, expression.asString());
    }

    @Override
    public String asString() {
        return operandAsString(first) + symbol + operandAsString(second);
    }

    @Override
    public float calculate() {
        return operator.apply(first.calculate(), second.calculate());
    }
}
