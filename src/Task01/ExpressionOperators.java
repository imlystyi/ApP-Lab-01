/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #01,
 * "ExpressionOperators.java" file */

package Task01;

public enum ExpressionOperators {
    // region Values

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    // endregion

    // region Fields

    private final String operator;

    // endregion

    // region Constructors

    ExpressionOperators(final String operator) {
        this.operator = operator;
    }

    // endregion

    // region Methods

    public static ExpressionOperators fromString(final String operator) {
        for (final ExpressionOperators expressionOperator : ExpressionOperators.values()) {
            if (expressionOperator.operator.equals(operator)) {
                return expressionOperator;
            }
        }

        throw new IllegalArgumentException("Error: unknown operator.");
    }

    // endregion
}
