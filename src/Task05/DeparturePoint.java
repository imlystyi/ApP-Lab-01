/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "DeparturePoint.java" file */

package Task05;

import java.util.UUID;

public class DeparturePoint implements IPoint {
    // region Fields

    public final int number;
    public final String oblast;
    public final String city;
    public final String street;
    public final String building;
    public UUID[] shipmentIds = new UUID[] {};

    // endregion

    // region Constructors

    public DeparturePoint(final int number, final String oblast, final String city, final String street,
                          final String building) {
        this.number = number;
        this.oblast = oblast;
        this.city = city;
        this.street = street;
        this.building = building;
    }

    // endregion

    // region Methods

    public Shipment[] cancelShipment(final Shipment[] shipments, final IPoint toPoint, final UUID shipmentId) {
        final int shipmentsNumber = shipments.length;
        final Shipment[] newShipments = new Shipment[shipmentsNumber - 1];

        for (int ii = 0, jj = 0; ii < shipmentsNumber; ii++)
            if (shipments[ii].id != shipmentId)
                newShipments[jj++] = shipments[ii];

        this.deleteShipmentId(shipmentId);
        toPoint.deleteShipmentId(shipmentId);

        return newShipments;
    }

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

    public Shipment[] createShipment(final Shipment[] shipments, final IPoint toPoint, final ShipmentMethods method,
                                     final Item item) {
        final Shipment shipment = new Shipment(this, toPoint, method, item);

        final int shipmentsNumber = shipments.length;
        final Shipment[] newShipments = new Shipment[shipmentsNumber + 1];
        System.arraycopy(shipments, 0, newShipments, 0, shipmentsNumber);
        newShipments[shipmentsNumber] = shipment;

        final UUID shipmentId = shipment.id;
        this.addShipmentId(shipmentId);
        toPoint.addShipmentId(shipmentId);

        return newShipments;
    }

    @Override
    public String toString() {
        return String.format("DP №%d: %s oblast, %s, %s, %s",
                this.number, this.oblast, this.city, this.street, this.building);
    }

    // endregion
}
