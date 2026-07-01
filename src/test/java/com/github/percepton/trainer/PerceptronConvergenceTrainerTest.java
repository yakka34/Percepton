package com.github.percepton.trainer;

import com.github.percepton.data.Bit;
import com.github.percepton.data.TrainingData;
import com.github.percepton.data.TrainingResult;
import com.github.percepton.function.PerceptronFunction;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PerceptronConvergenceTrainerTest {

    private void assertTrainingResult(final TrainingResult trainingResult, final List<TrainingData> trainingDataList) {
        final PerceptronFunction perceptron = new PerceptronFunction();
        trainingDataList.forEach(trainingData -> {
            final Bit output = perceptron.apply(trainingData.input(), trainingResult.weights(), trainingResult.bias());
            assertEquals(trainingData.expectedOutput(), output);
        });
    }

    @Test
    void shouldConvergeOnAnd() {
        final List<TrainingData> and = List.of(
                new TrainingData(new float[]{0f, 0f}, Bit.ZERO),
                new TrainingData(new float[]{0f, 1f}, Bit.ZERO),
                new TrainingData(new float[]{1f, 0f}, Bit.ZERO),
                new TrainingData(new float[]{1f, 1f}, Bit.ONE));

        final Optional<TrainingResult> result = new PerceptronConvergenceTrainer().train(and);

        assertTrue(result.isPresent());
        assertTrainingResult(result.get(), and);
    }

    @Test
    public void shouldConvergeOnOr() {
        final List<TrainingData> or = List.of(
                new TrainingData(new float[]{0f, 0f}, Bit.ZERO),
                new TrainingData(new float[]{0f, 1f}, Bit.ONE),
                new TrainingData(new float[]{1f, 0f}, Bit.ONE),
                new TrainingData(new float[]{1f, 1f}, Bit.ONE));

        final Optional<TrainingResult> result = new PerceptronConvergenceTrainer().train(or);

        assertTrue(result.isPresent());
        assertTrainingResult(result.get(), or);
    }

    @Test
    public void shouldConvergeOnNand() {
        final List<TrainingData> nand = List.of(
                new TrainingData(new float[]{0f, 0f}, Bit.ONE),
                new TrainingData(new float[]{0f, 1f}, Bit.ONE),
                new TrainingData(new float[]{1f, 0f}, Bit.ONE),
                new TrainingData(new float[]{1f, 1f}, Bit.ZERO));

        final Optional<TrainingResult> result = new PerceptronConvergenceTrainer().train(nand);

        assertTrue(result.isPresent());
        assertTrainingResult(result.get(), nand);
    }

    @Test
    public void shouldConvergeOnNor() {
        final List<TrainingData> nor = List.of(
                new TrainingData(new float[]{0f, 0f}, Bit.ONE),
                new TrainingData(new float[]{0f, 1f}, Bit.ZERO),
                new TrainingData(new float[]{1f, 0f}, Bit.ZERO),
                new TrainingData(new float[]{1f, 1f}, Bit.ZERO));

        final Optional<TrainingResult> result = new PerceptronConvergenceTrainer().train(nor);

        assertTrue(result.isPresent());
        assertTrainingResult(result.get(), nor);
    }

    @Test
    public void shouldConvergeOnDataThatRequiresNonZeroThreshold() {
        final List<TrainingData> nonOrigin = List.of(
                new TrainingData(new float[]{2f, 2f}, Bit.ONE),
                new TrainingData(new float[]{0f, 0f}, Bit.ZERO),
                new TrainingData(new float[]{3f, 1f}, Bit.ONE));

        final Optional<TrainingResult> result = new PerceptronConvergenceTrainer().train(nonOrigin);

        assertTrue(result.isPresent());
        assertTrainingResult(result.get(), nonOrigin);
    }

    @Test
    public void shouldNotConvergeOnXor() {
        final List<TrainingData> xor = List.of(
                new TrainingData(new float[]{0f, 0f}, Bit.ZERO),
                new TrainingData(new float[]{0f, 1f}, Bit.ONE),
                new TrainingData(new float[]{1f, 0f}, Bit.ONE),
                new TrainingData(new float[]{1f, 1f}, Bit.ZERO));

        final Optional<TrainingResult> result = new PerceptronConvergenceTrainer().train(xor);

        assertTrue(result.isEmpty());
    }

}