package com.github.percepton.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DotProductFunctionTest {

    @Test
    public void shouldThrowExceptionWhenArrayLengthsDoNotMatch() {
        final float[] vectorX = {1f, 2f};
        final float[] vectorY = {1f};

        assertThrows(IllegalArgumentException.class, () -> VectorOperations.DOT_PRODUCT.apply(vectorX, vectorY));
    }

    @Test
    public void shouldReturnZeroWhenArraysAreEmpty() {
        final float[] x = {};
        final float[] y = {};

        final float result = VectorOperations.DOT_PRODUCT.apply(x, y);

        assertEquals(0f, result, 0f);
    }

    @Test
    public void shouldReturnCorrectDotProductForMatchingArrays() {
        final float[] x = {1f, 2f, 3f};
        final float[] y = {4f, 5f, 6f};

        final float result = VectorOperations.DOT_PRODUCT.apply(x, y);

        assertEquals(32f, result, 0f);
    }

}