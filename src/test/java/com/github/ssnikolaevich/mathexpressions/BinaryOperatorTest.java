package com.github.ssnikolaevich.mathexpressions;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryOperatorTest {
    @Test
    public void testGetPrecedence() {
        BinaryOperator expression = new BinaryOperator(42, null, null, null, null);
        assertEquals(42, expression.getPrecedence());
    }

    @Test
    public void testAsString() {
        BinaryOperator expression;

        expression = new BinaryOperator(
                Presedences.ADDSUB,
                new IntegerConstant(1),
                new IntegerConstant(-2),
                "+",
                null
        );
        assertEquals("1+(-2)", expression.asString());

        expression = new BinaryOperator(
                Presedences.ADDSUB,
                new IntegerConstant(-1),
                new IntegerConstant(2),
                "+",
                null
        );
        assertEquals("(-1)+2", expression.asString());

        expression = new BinaryOperator(
                Presedences.ADDSUB,
                new IntegerConstant(1),
                new IntegerConstant(2),
                "+",
                null
        );
        assertEquals("1+2", expression.asString());

        expression = new BinaryOperator(
                -1,
                new IntegerConstant(1),
                new IntegerConstant(2),
                "+",
                null
        );
        assertEquals("1+2", expression.asString());
    }

    @Test
    public void testCalculate() {
        BinaryOperator.Operator operator = new BinaryOperator.Operator() {
            @Override
            public float apply(float first, float second) {
                return first % second;
            }
        };
        BinaryOperator expression = new BinaryOperator(
                Presedences.MULDIV,
                new IntegerConstant(5),
                new IntegerConstant(3),
                "%",
                operator
        );
        assertEquals(2.0, expression.calculate(), 0.001);
    }
}
