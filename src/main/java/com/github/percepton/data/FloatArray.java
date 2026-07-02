package com.github.percepton.data;

import java.io.Serializable;
import java.util.Arrays;

public class FloatArray implements Serializable {

    private static final FloatArray EMPTY = new FloatArray(new float[0]);

    public static FloatArray of() {
        return EMPTY;
    }

    public static FloatArray of(final float... values) {
        return new FloatArray(values);
    }

    private final float[] array;

    private FloatArray(final float[] array) {
        this.array = array;
    }

    public float[] get() {
        return this.array;
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof final FloatArray that) {
            return Arrays.equals(this.array, that.array);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.array);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }

}
