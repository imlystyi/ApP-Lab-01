/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "Point.java" file */

package Task05;

import java.util.Objects;

public abstract class Point {
    // region Fields

    private final String oblast;
    private final String city;
    private final String street;
    private final String building;

    // endregion

    // region Constructors

    public Point(final String oblast, final String city, final String street, final String building) {
        this.oblast = oblast;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    // endregion

    // region Methods

    public boolean hasSameAddress(Point point) {
        return Objects.equals(this.oblast, point.oblast) && Objects.equals(this.city, point.city) &&
               Objects.equals(this.street, point.street) && Objects.equals(this.building, point.building);
    }

    @Override
    public String toString() {
        return String.format("%s oblast, %s, %s, %s", this.oblast, this.city, this.street, this.building);
    }

    // endregion
}
