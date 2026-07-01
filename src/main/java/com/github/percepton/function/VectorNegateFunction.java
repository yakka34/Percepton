package com.github.percepton.function;

import java.util.function.Function;

public class VectorNegateFunction implements Function<float[], float[]> {

    @Override
    public float[] apply(final float[] x) {
        final float[] result = new float[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = -x[i];
        }
        return result;
    }

}
