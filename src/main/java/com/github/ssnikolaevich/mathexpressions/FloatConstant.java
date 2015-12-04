package com.github.ssnikolaevich.mathexpressions;

public class FloatConstant extends Expression {
    private float value;

    public FloatConstant(float value) {
        super(Presedences.CONSTANT);
        this.value = value;
    }

    @Override
    public String asString() {
        return Float.toString(value);
    }

    @Override
    public float calculate() {
        return value;
    }
}
