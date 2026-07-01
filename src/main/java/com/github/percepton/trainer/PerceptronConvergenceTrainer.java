package com.github.percepton.trainer;

import com.github.percepton.data.Bias;
import com.github.percepton.data.Bit;
import com.github.percepton.data.TrainingData;
import com.github.percepton.data.TrainingResult;
import com.github.percepton.function.VectorOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PerceptronConvergenceTrainer {

    private static float[] addBias(final float[] input) {
        final float[] result = new float[input.length + 1];
        System.arraycopy(input, 0, result, 0, input.length);
        result[input.length] = 1.0f;
        return result;
    }

    private static float[] preprocessTrainingData(final TrainingData trainingData) {
        final float[] augmentedInput = addBias(trainingData.input());
        if (Bit.ZERO == trainingData.expectedOutput()) {
            return VectorOperations.VECTOR_NEGATE.apply(augmentedInput);
        }
        return augmentedInput;
    }


    private static float[][] preprocessTrainingData(final List<TrainingData> trainingDataList) {
        final float[][] inputs = new float[trainingDataList.size()][];
        for (int i = 0; i < trainingDataList.size(); i++) {
            inputs[i] = preprocessTrainingData(trainingDataList.get(i));
        }
        return inputs;
    }

    private TrainingResult mapTrainingResult(final float[] weights, final int epoch, final int mistakes) {
        final int biasIndex = weights.length - 1;
        final Bias bias = new Bias(weights[biasIndex]);
        return new TrainingResult(Arrays.copyOf(weights, biasIndex), bias, epoch, mistakes);
    }

    public Optional<TrainingResult> train(final List<TrainingData> trainingData) {
        if (trainingData.isEmpty()) {
            return Optional.empty();
        }
        final float[][] inputs = preprocessTrainingData(trainingData);
        float[] weights = inputs[0].clone();
        for (int epoch = 0, mistakes = 0; epoch < 100; epoch++) {
            boolean error = false;
            for (final float[] input : inputs) {
                final float sum = VectorOperations.DOT_PRODUCT.apply(weights, input);
                if (sum <= 0) {
                    mistakes++;
                    error = true;
                    weights = VectorOperations.VECTOR_ADDITION.apply(weights, input);
                }
            }
            if (!error) {
                return Optional.of(mapTrainingResult(weights, epoch + 1, mistakes));
            }
        }
        return Optional.empty();
    }

}
