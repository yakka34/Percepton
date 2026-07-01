package com.github.percepton.data;

public final class TrainingData {

    private final float[] input;
    private final Bit expectedOutput;

    public TrainingData(final float[] input, final Bit expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    public float[] input() {
        return input;
    }

    public Bit expectedOutput() {
        return expectedOutput;
    }

}
