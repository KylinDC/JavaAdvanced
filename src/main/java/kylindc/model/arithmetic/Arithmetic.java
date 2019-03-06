package main.java.kylindc.model.arithmetic;

@FunctionalInterface
public interface Arithmetic<T, U, R> {
    R apply(T t, U u);

    static Arithmetic getCalculation(ArithmeticOperator operator) {
        Arithmetic<Integer, Integer, Integer> operation = null;
        switch (operator) {
            case ADDITION:
                operation = (a, b) -> a + b;
                break;
            case SUBTRACTION:
                operation = (a, b) -> a - b;
                break;
            case MULTIPLICATION:
                operation = (a, b) -> a * b;
                break;
            case DIVISION:
                operation = (a, b) -> a / b;
                break;
            default:
                break;
        }
        return operation;
    }
}