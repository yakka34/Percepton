package com.github.percepton.function;

import java.util.function.BiFunction;

public class DotProductFunction implements BiFunction<float[], float[], Float> {

    @Override
    public Float apply(final float[] x, final float[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Input arrays must have the same length");
        }
        float sum = 0f;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }

}
