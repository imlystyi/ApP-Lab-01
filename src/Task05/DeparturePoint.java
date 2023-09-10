/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "DeparturePoint.java" file */

package Task05;

public class DeparturePoint extends Point {
    // region Fields

    private final int number;

    // endregion

    // region Constructors

    public DeparturePoint(final int number, final String oblast, final String city, final String street,
                          final String building) {
        super(oblast, city, street, building);
        this.number = number;
    }

    // endregion

    // region Methods

    @Override
    public String toString() {
        return String.format("DP №%d: ", this.number) + super.toString();
    }

    // endregion
}
