package com.github.ssnikolaevich.mathexpressions;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class FloatConstantTest {
    private FloatConstant expression;

    @Before
    public void setUp() {
        expression = new FloatConstant(3.2f);
    }

    @Test
    public void testGetPrecedence() {
        assertEquals(Presedences.CONSTANT, expression.getPrecedence());
    }

    @Test
    public void testCalculate() {
        assertEquals(3.2f, expression.calculate(), 0.001);
    }

    @Test
    public void testAsString() {
        assertEquals("3.2", expression.asString());
    }
}
