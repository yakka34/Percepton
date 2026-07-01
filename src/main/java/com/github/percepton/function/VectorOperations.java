package com.github.percepton.function;

public class VectorOperations {

    private VectorOperations() {

    }

    public static final DotProductFunction DOT_PRODUCT = new DotProductFunction();
    public static final VectorAdditionFunction VECTOR_ADDITION = new VectorAdditionFunction();
    public static final VectorNegateFunction VECTOR_NEGATE = new VectorNegateFunction();

}
