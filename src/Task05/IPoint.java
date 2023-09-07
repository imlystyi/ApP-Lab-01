/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "IPoint.java" file */

package Task05;

import java.util.UUID;

public interface IPoint {
    void addShipmentId(final UUID shipmentId);

    void deleteShipmentId(final UUID shipmentId);
}
