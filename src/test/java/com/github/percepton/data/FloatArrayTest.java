package com.github.percepton.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class FloatArrayTest {

    @Test
    void shouldReturnCachedEmpty() {
        final FloatArray empty1 = FloatArray.of();
        final FloatArray empty2 = FloatArray.of();

        assertSame(empty1, empty2);
        assertEquals(empty1, empty2);
    }

    @Test
    void shouldReturnStringRepresentation() {
        final FloatArray floatArray = FloatArray.of(-1f, 0f, 1f);

        assertEquals("[-1.0, 0.0, 1.0]", floatArray.toString());
    }

    @Test
    void shouldReturnHashCodeOfContents() {
        final FloatArray floatArray1 = FloatArray.of(-2f, 1f, 0f);
        final FloatArray floatArray2 = FloatArray.of(-2f, 1f, 0f);

        assertNotSame(floatArray1, floatArray2);
        assertEquals(floatArray1.hashCode(), floatArray2.hashCode());
    }

    @Test
    void shouldReturnTrueForEquals() {
        final FloatArray floatArray1 = FloatArray.of(-3f, 2f, 0f);
        final FloatArray floatArray2 = FloatArray.of(-3f, 2f, 0f);

        assertEquals(floatArray1, floatArray2);
    }

    @Test
    void shouldReturnFalseForEquals() {
        final FloatArray floatArray1 = FloatArray.of(0f, 2f, -3f);
        final FloatArray floatArray2 = FloatArray.of(-3f, 2f, 0f);

        assertNotEquals(floatArray1, floatArray2);
    }

    @Test
    void shouldReturnWrappedArray() {
        final float[] array = {-5f, 2f, 10f, 1.5f};
        final FloatArray floatArray = FloatArray.of(array);

        assertSame(array, floatArray.get());
    }

}