package com.github.percepton.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorAdditionFunctionTest {

    @Test
    public void shouldThrowExceptionWhenArrayLengthsDoNotMatch() {
        final float[] vectorX = {1f, 2f};
        final float[] vectorY = {1f};

        assertThrows(IllegalArgumentException.class, () -> VectorOperations.VECTOR_ADDITION.apply(vectorX, vectorY));
    }

    @Test
    public void shouldReturnEmptyArrayWhenArraysAreEmpty() {
        final float[] x = {};
        final float[] y = {};

        final float[] result = VectorOperations.VECTOR_ADDITION.apply(x, y);

        assertArrayEquals(new float[]{}, result, 0f);
    }

    @Test
    public void shouldReturnSumForPositiveValues() {
        final float[] x = {1f, 2f, 3f};
        final float[] y = {4f, 5f, 6f};
        final float[] expected = {5f, 7f, 9f};

        final float[] result = VectorOperations.VECTOR_ADDITION.apply(x, y);

        assertArrayEquals(expected, result, 0f);
    }

    @Test
    public void shouldReturnSumForNegativeValues() {
        final float[] x = {1f, -2f, 3.5f};
        final float[] y = {-0.5f, 2f, -1f};
        final float[] expected = {0.5f, 0f, 2.5f};

        final float[] result = VectorOperations.VECTOR_ADDITION.apply(x, y);

        assertArrayEquals(expected, result, 0f);
    }

}