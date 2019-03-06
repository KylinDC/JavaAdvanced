package test.java.kylindc.model.arithmetic;

import main.java.kylindc.model.arithmetic.Arithmetic;
import main.java.kylindc.model.arithmetic.ArithmeticOperator;

public class ArithmeticTest {
    public static void main(String[] args) {
        Arithmetic<Integer, Integer, Integer> add =
                Arithmetic.getCalculation(ArithmeticOperator.ADDITION);
        Arithmetic<Integer, Integer, Integer> subtract =
                Arithmetic.getCalculation(ArithmeticOperator.SUBTRACTION);
        Arithmetic<Integer, Integer, Integer> multiply =
                Arithmetic.getCalculation(ArithmeticOperator.MULTIPLICATION);
        Arithmetic<Integer, Integer, Integer> divide =
                Arithmetic.getCalculation
                        (ArithmeticOperator.DIVISION);

        System.out.println(add.apply(2, 3));
        System.out.println(subtract.apply(2, 3));
        System.out.println(multiply.apply(2, 3));
        System.out.println(divide.apply(2, 3));
    }
}
