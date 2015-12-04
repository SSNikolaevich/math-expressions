package com.github.ssnikolaevich.mathexpressions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerConstantTest {
    private IntegerConstant expression;
    private IntegerConstant negativeExpression;

    @Before
    public void setUp() {
        expression = new IntegerConstant(5);
        negativeExpression = new IntegerConstant(-1);
    }

    @Test
    public void testGetPrecedence() {
        assertEquals(Presedences.CONSTANT, expression.getPrecedence());
        assertEquals(Presedences.SIGN, negativeExpression.getPrecedence());
    }

    public void testCalculate() {
        assertEquals(5.0, expression.calculate(), 0.001);
        assertEquals(-1, negativeExpression.calculate(), 0.001);
    }

    public void testAsString() {
        assertEquals("5", expression.asString());
        assertEquals("-1", negativeExpression.asString());
    }
}
