package com.github.percepton.trainer;

import com.github.percepton.data.Bit;
import com.github.percepton.data.TrainingData;
import com.github.percepton.data.TrainingResult;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PerceptronConvergenceTrainerIrisTest {

    private List<String[]> readData(final String filename) throws IOException {
        final String path = "src/test/resources/%s".formatted(filename);
        try (final Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.map(line -> line.split(",")).toList();
        }
    }

    private TrainingData mapTrainingData(final String[] row, final String expectedIrisPlantClass) {
        final float[] input = {
                Float.parseFloat(row[0]),
                Float.parseFloat(row[1]),
                Float.parseFloat(row[2]),
                Float.parseFloat(row[3]),
        };
        return new TrainingData(input, expectedIrisPlantClass.equals(row[4]) ? Bit.ONE : Bit.ZERO);
    }

    @Test
    void shouldConvergeOnIrisSetosa() throws IOException {
        final List<String[]> trainingRows = readData("iris/iris.data");
        final List<TrainingData> trainingData = trainingRows.stream()
                .map(x -> mapTrainingData(x, "Iris-setosa"))
                .toList();
        final Optional<TrainingResult> maybeTrainingResult = new PerceptronConvergenceTrainer().train(trainingData);
        assertTrue(maybeTrainingResult.isPresent());
    }

    @Test
    void shouldNotConvergeOnIrisVersicolor() throws IOException {
        final List<String[]> trainingRows = readData("iris/iris.data");
        final List<TrainingData> trainingData = trainingRows.stream()
                .map(x -> mapTrainingData(x, "Iris-versicolor"))
                .toList();
        final Optional<TrainingResult> maybeTrainingResult = new PerceptronConvergenceTrainer().train(trainingData);
        assertFalse(maybeTrainingResult.isPresent());
    }

    @Test
    void shouldNotConvergeOnIrisVirginica() throws IOException {
        final List<String[]> trainingRows = readData("iris/iris.data");
        final List<TrainingData> trainingData = trainingRows.stream()
                .map(x -> mapTrainingData(x, "Iris-virginica"))
                .toList();
        final Optional<TrainingResult> maybeTrainingResult = new PerceptronConvergenceTrainer().train(trainingData);
        assertFalse(maybeTrainingResult.isPresent());
    }

}