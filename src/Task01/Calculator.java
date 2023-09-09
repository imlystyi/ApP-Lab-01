/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #01,
 * "Calculator.java" file */

package Task01;

public class Calculator {
    public static double compute(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Error: the expression cannot be empty.");
        }

        final Expression expression = new Expression(input);

        final double firstOperand = expression.getFirstOperand();
        final double secondOperand = expression.getSecondOperand();
        final ExpressionOperators operator = expression.getOperator();

        switch (operator) {
            case ADDITION -> {
                return add(firstOperand, secondOperand);
            }
            case SUBTRACTION -> {
                return subtract(firstOperand, secondOperand);
            }
            case MULTIPLICATION -> {
                return multiply(firstOperand, secondOperand);
            }
            case DIVISION -> {
                return divide(firstOperand, secondOperand);
            }
            default -> throw new IllegalArgumentException("Error: unknown operator.");
        }
    }

    private static double add(final double firstOperand, final double secondOperand) {
        return firstOperand + secondOperand;
    }

    private static double subtract(final double firstOperand, final double secondOperand) {
        return firstOperand - secondOperand;
    }

    private static double multiply(final double firstOperand, final double secondOperand) {
        return firstOperand * secondOperand;
    }

    private static double divide(final double firstOperand, final double secondOperand) {
        if (secondOperand == 0)
            throw new ArithmeticException("Error: division by zero or a number too large.");

        return firstOperand / secondOperand;
    }
}
