package com.github.ssnikolaevich.mathexpressions;

import java.util.Random;

public class ExpressionGenerator {
    private int minValue;
    private int maxValue;
    private boolean enableMulDiv;
    private Random random;

    public ExpressionGenerator() {
        this.minValue = 0;
        this.maxValue = 9;
        this.random = new Random();
    }

    public void setSeed(long seed) {
        random.setSeed(seed);
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setEnableMulDiv(boolean enable) {
        this.enableMulDiv = enable;
    }

    public Expression generate(int depth) {
        if (depth > 0) {
            Expression first = generate(depth - 1);
            Expression second = generate(depth - 1);
            if (enableMulDiv && random.nextBoolean()) {
                if (random.nextBoolean()) {
                    return MathOperators.mul(first, second);
                } else {
                    int a = Math.round(first.calculate());
                    int b = Math.round(second.calculate());
                    if (b == 0) {
                        b = Math.min(1, minValue) + random.nextInt(maxValue - minValue);
                    }
                    return MathOperators.div(
                            new IntegerConstant(a * b),
                            new IntegerConstant(b)
                    );
                }
            } else {
                if (random.nextBoolean()) {
                    return MathOperators.add(first, second);
                } else {
                    boolean firstIsGreater = first.calculate() > second.calculate();
                    return MathOperators.sub(
                            firstIsGreater? first : second,
                            firstIsGreater? second : first
                    );
                }
            }
        } else {
            int value = minValue + random.nextInt(maxValue - minValue);
            return new IntegerConstant(value);
        }
    }
}
