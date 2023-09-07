/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #01,
 * "Calculator.java" file */

package Task01;

public class Calculator {
    public static String compute(final String input) {
        if (input.isEmpty())
            return "Error: expression cannot be empty.";

        final String[] expression = getExpression(input);
        if (expression.length > 3)
            return "Error: too many operands and/or operators.";

        try {
            final double firstOperand = Double.parseDouble(expression[0]);
            final String operator = expression[1];
            final double secondOperand = Double.parseDouble(expression[2]);

            switch (operator) {
                case "+" -> {
                    return add(firstOperand, secondOperand).toString();
                }
                case "-" -> {
                    return subtract(firstOperand, secondOperand).toString();
                }
                case "*" -> {
                    return multiply(firstOperand, secondOperand).toString();
                }
                case "/" -> {
                    return divide(firstOperand, secondOperand).toString();
                }
                default -> {
                    return "Error: invalid operator sign.";
                }
            }
        } catch (final NumberFormatException ex) {
            return "Error: the operands in the expression must be numbers.";
        } catch (final IndexOutOfBoundsException ex) {
            return "Error: the expression is incomplete.";
        } catch (final ArithmeticException ex) {
            return "Error: division by zero or a number too large.";
        }
    }

    private static String[] getExpression(final String input) {
        char ch;
        for (int ii = 0; ii < input.length(); ii++) {
            ch = input.charAt(ii);
            if (!Character.isDigit(ch) && ch != '.') // Checking if a character is a digit, if not - the assumption
                                                     // that it is an operator.
                return new String[] { input.substring(0, ii), String.valueOf(input.charAt(ii)),
                        input.substring(ii + 1) };
        }

        return new String[] {};
    }

    private static Double add(final double firstOperand, final double secondOperand) {
        return firstOperand + secondOperand;
    }

    private static Double subtract(final double firstOperand, final double secondOperand) {
        return firstOperand - secondOperand;
    }

    private static Double multiply(final double firstOperand, final double secondOperand) {
        return firstOperand * secondOperand;
    }

    private static Double divide(final double firstOperand, final double secondOperand) {
        if (secondOperand == 0)
            throw new ArithmeticException();

        return firstOperand / secondOperand;
    }
}
