/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #01,
 * "Expression.java" file */

package Task01;

public class Expression {
    // region Fields

    private final double firstOperand;
    private final double secondOperand;
    private final ExpressionOperators operator;

    // endregion

    // region Getters and setters

    public double getFirstOperand() {
        return this.firstOperand;
    }

    public double getSecondOperand() {
        return this.secondOperand;
    }

    public ExpressionOperators getOperator() {
        return this.operator;
    }

    // endregion

    // region Constructors

    public Expression(final String stringRepresentation) {
        char ch;
        for (int ii = 0; ii < stringRepresentation.length(); ii++) {
            ch = stringRepresentation.charAt(ii);
            if (!Character.isDigit(ch) && ch != '.') {
                try {
                    this.firstOperand = Double.parseDouble(stringRepresentation.substring(0, ii));
                    this.secondOperand = Double.parseDouble(stringRepresentation.substring(ii + 1));
                    this.operator = ExpressionOperators.fromString(String.valueOf(stringRepresentation.charAt(ii)));
                } catch (final NumberFormatException | NullPointerException ex) {
                    throw new IllegalArgumentException("Error: the expression is invalid.");
                }

                return;
            }
        }

        throw new IllegalArgumentException("Error: the expression is invalid.");
    }

    // endregion
}
