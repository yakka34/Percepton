package com.github.percepton.data;

public record TrainingResult(FloatArray weights, Bias bias, int epochs, int mistakes) {

}
