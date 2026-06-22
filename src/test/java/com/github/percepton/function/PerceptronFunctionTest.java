package com.github.percepton.function;

import com.github.percepton.data.Bias;
import com.github.percepton.data.Bit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerceptronFunctionTest {

    private static final float ZERO = 0f;
    private static final float ONE = 1f;
    private static final float WEIGHT = -2f;
    private static final Bias BIAS = new Bias(3);

    @Test
    public void shouldProduceNandGateTruthTableOutputsForAllInputCombinations() {
        final PerceptronFunction perceptron = new PerceptronFunction();
        assertEquals(Bit.ONE, perceptron.apply(
                new float[]{ZERO, ZERO},
                new float[]{WEIGHT, WEIGHT},
                BIAS));
        assertEquals(Bit.ONE, perceptron.apply(
                new float[]{ZERO, ONE},
                new float[]{WEIGHT, WEIGHT},
                BIAS));
        assertEquals(Bit.ONE, perceptron.apply(
                new float[]{ONE, ZERO},
                new float[]{WEIGHT, WEIGHT},
                BIAS));
        assertEquals(Bit.ZERO, perceptron.apply(
                new float[]{ONE, ONE},
                new float[]{WEIGHT, WEIGHT},
                BIAS));
    }

}