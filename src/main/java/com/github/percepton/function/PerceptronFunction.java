package com.github.percepton.function;

import com.github.percepton.data.Bias;
import com.github.percepton.data.Bit;

public class PerceptronFunction implements TriFunction<float[], float[], Bias, Bit> {

    @Override
    public Bit apply(final float[] inputs, final float[] weights, final Bias bias) {
        return VectorOperations.DOT_PRODUCT
                .andThen(dotProduct -> dotProduct + bias.value())
                .andThen(ActivationFunctions.HEAVISIDE_STEP_FUNCTION)
                .apply(inputs, weights);
    }

}
