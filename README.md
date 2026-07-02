# Percepton

Java implementation of Frank Rosenblatt's 1957 Perceptron algorithm with a convergence trainer based on Theorem 11.1: Perceptron Convergence Theorem from *Perceptrons* (expanded edition) by Marvin Minsky and Seymour A. Papert.

## Theorem 11.1: Perceptron Convergence Theorem

> The trainer is **guaranteed to converge** if the training dataset is linearly separable.

`PerceptronConvergenceTrainer` implements the convergence algorithm:

1. **Add bias** to each input vector (appends `1.0`)
2. **Negate** training data input vector for `ZERO`-class examples, so all correct classifications reduce to a single condition: `w · x > 0 for all x ∈ F`, where F = F⁺ ∪ F⁻
3. **Train** — Train for a maximum of predetermined epochs or until convergence. If data is linearly separable it is guaranteed to converge, but in practice we don't know that beforehand. Therefore, the epoch limit is a timeout of sorts.
4. **Converge** — return `TrainingResult` if convergence is found or `Optional.empty()` if no convergence is found after n epochs.

## Convergence Examples

| Problem         | Linearly Separable | Converges |
|-----------------|--------------------|-----------|
| AND             | Yes                | Yes       |
| OR              | Yes                | Yes       |
| NAND            | Yes                | Yes       |
| NOR             | Yes                | Yes       |
| XOR             | No                 | No        |
| Iris Setosa     | Yes                | Yes       |
| Iris Versicolor | No                 | No        |
| Iris Virginica  | No                 | No        |

XOR and the overlapping Iris classes are not linearly separable — the trainer returns `Optional.empty()`.

## Build & Test

```bash
mvn test
```

## References

- Minsky, M., & Papert, S. A. (1969/1988). *Perceptrons: An Introduction to Computational Geometry* (expanded edition). MIT Press. — Theorem 11.1: Perceptron Convergence Theorem
- Rosenblatt, F. (1957). *The Perceptron: A Perceiving and Recognizing Automaton*. Cornell Aeronautical Laboratory.
- Fisher, R. A. (1936). Iris dataset. UCI Machine Learning Repository.
