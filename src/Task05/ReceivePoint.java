/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "ReceivePoint.java" file */

package Task05;

public class ReceivePoint extends Point {
    // region Constructor

    public ReceivePoint(final String oblast, final String city, final String street, final String building) {
        super(oblast, city, street, building);
    }

    // endregion

    // region Methods

    @Override
    public String toString() {
        return "RP: " + super.toString();
    }

    // endregion
}
