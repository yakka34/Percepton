package com.github.percepton.function;

import com.github.percepton.data.Bit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeavisideStepFunctionTest {

    @Test
    public void shouldReturnZeroForNegativeInput() {
        final float input = -1f;
        final Bit result = ActivationFunctions.HEAVISIDE_STEP_FUNCTION.apply(input);

        assertEquals(Bit.ZERO, result);
    }

    @Test
    public void shouldReturnZeroForZeroInput() {
        final float input = 0f;
        final Bit result = ActivationFunctions.HEAVISIDE_STEP_FUNCTION.apply(input);

        assertEquals(Bit.ZERO, result);
    }

    @Test
    public void shouldReturnOneForPositiveInput() {
        final float input = 1f;
        final Bit result = ActivationFunctions.HEAVISIDE_STEP_FUNCTION.apply(input);

        assertEquals(Bit.ONE, result);
    }

}