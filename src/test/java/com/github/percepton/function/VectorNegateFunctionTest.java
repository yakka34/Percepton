package com.github.percepton.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class VectorNegateFunctionTest {

    @Test
    public void shouldReturnEmptyArrayWhenInputIsEmpty() {
        final float[] x = {};

        final float[] result = VectorOperations.VECTOR_NEGATE.apply(x);

        assertArrayEquals(new float[]{}, result, 0f);
    }

    @Test
    public void shouldNegatePositiveValues() {
        final float[] x = {1f, 2f, 3f};

        final float[] result = VectorOperations.VECTOR_NEGATE.apply(x);

        assertArrayEquals(new float[]{-1f, -2f, -3f}, result, 0f);
    }

    @Test
    public void shouldNegateNegativeValues() {
        final float[] x = {-1f, -2f, -3f};

        final float[] result = VectorOperations.VECTOR_NEGATE.apply(x);

        assertArrayEquals(new float[]{1f, 2f, 3f}, result, 0f);
    }

    @Test
    public void shouldNegateMixedSignValues() {
        final float[] x = {-1f, 2f, -3f, 4f};

        final float[] result = VectorOperations.VECTOR_NEGATE.apply(x);

        assertArrayEquals(new float[]{1f, -2f, 3f, -4f}, result, 0f);
    }

    @Test
    public void shouldNegateZeroToZero() {
        final float[] x = {0f, 0f};

        final float[] result = VectorOperations.VECTOR_NEGATE.apply(x);

        assertArrayEquals(new float[]{0f, 0f}, result, 0f);
    }

    @Test
    public void shouldReturnOriginalWhenNegatedTwice() {
        final float[] x = {1f, -2f, 3f};

        final float[] result = VectorOperations.VECTOR_NEGATE.apply(
                VectorOperations.VECTOR_NEGATE.apply(x));

        assertArrayEquals(new float[]{1f, -2f, 3f}, result, 0f);
    }

}