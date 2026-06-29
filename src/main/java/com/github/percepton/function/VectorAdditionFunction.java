package com.github.percepton.function;

import java.util.function.BiFunction;

public class VectorAdditionFunction implements BiFunction<float[], float[], float[]> {

    @Override
    public float[] apply(final float[] x, final float[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Input arrays must have the same length");
        }
        final float[] result = new float[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = x[i] + y[i];
        }
        return result;
    }

}
