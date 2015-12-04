package com.github.ssnikolaevich.mathexpressions;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class MathOperatorsTest {
    private Expression first;
    private Expression second;

    @Before
    public void setUp() {
        first = new IntegerConstant(3);
        second = new IntegerConstant(2);
    }
    @Test
    public void testAdd() {
        Expression expression = MathOperators.add(first, second);
        assertEquals(Presedences.ADDSUB, expression.getPrecedence());
        assertEquals(5.0, expression.calculate(), 0.001);
        assertEquals("3+2", expression.asString());
    }

    @Test
    public void testSub() {
        Expression expression = MathOperators.sub(first, second);
        assertEquals(Presedences.ADDSUB, expression.getPrecedence());
        assertEquals(1.0, expression.calculate(), 0.001);
        assertEquals("3-2", expression.asString());
    }

    @Test
    public void testMul() {
        Expression expression = MathOperators.mul(first, second);
        assertEquals(Presedences.MULDIV, expression.getPrecedence());
        assertEquals(6.0, expression.calculate(), 0.001);
        assertEquals("3\u00B72", expression.asString());
    }

    @Test
    public void testDiv() {
        Expression expression = MathOperators.div(first, second);
        assertEquals(Presedences.MULDIV, expression.getPrecedence());
        assertEquals(1.5, expression.calculate(), 0.001);
        assertEquals("3:2", expression.asString());
    }
}
