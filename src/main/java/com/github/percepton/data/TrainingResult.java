package com.github.percepton.data;

public final class TrainingResult {

    private final float[] weights;
    private final Bias bias;
    private final int epochs;
    private final int mistakes;

    public TrainingResult(final float[] weights, final Bias bias, final int epochs, final int mistakes) {
        this.weights = weights;
        this.bias = bias;
        this.epochs = epochs;
        this.mistakes = mistakes;
    }

    public float[] weights() {
        return weights;
    }

    public Bias bias() {
        return bias;
    }

    public int epochs() {
        return epochs;
    }

    public int mistakes() {
        return mistakes;
    }

}
