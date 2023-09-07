/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "ReceivePoint.java" file */

package Task05;

import java.util.UUID;

public class ReceivePoint implements IPoint {
    // region Fields

    public final String oblast;
    public final String city;
    public final String street;
    public final String building;
    public UUID[] shipmentIds = new UUID[] {};

    // endregion

    // region Constructor

    public ReceivePoint(final String oblast, final String city, final String street, final String building) {
        this.oblast = oblast;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    // endregion

    // region Methods

    @Override
    public void addShipmentId(final UUID shipmentId) {
        final int shipmentIdsNumber = this.shipmentIds.length;
        final UUID[] newShipmentIds = new UUID[shipmentIdsNumber + 1];
        System.arraycopy(this.shipmentIds, 0, newShipmentIds, 0, this.shipmentIds.length);
        newShipmentIds[shipmentIdsNumber] = shipmentId;

        this.shipmentIds = newShipmentIds;
    }

    @Override
    public void deleteShipmentId(final UUID shipmentId) {
        final int shipmentIdsNumber = this.shipmentIds.length;
        final UUID[] newShipmentIds = new UUID[shipmentIdsNumber - 1];

        for (int ii = 0, jj = 0; ii < shipmentIdsNumber; ii++)
            if (this.shipmentIds[ii] != shipmentId)
                newShipmentIds[jj++] = this.shipmentIds[ii];

        this.shipmentIds = newShipmentIds;
    }

    @Override
    public String toString() {
        return String.format("RP: %s oblast, %s, %s, %s",
                this.oblast, this.city, this.street, this.building);
    }

    // endregion
}
