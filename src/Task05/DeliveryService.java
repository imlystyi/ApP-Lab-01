/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "DeliveryService.java" file */

package Task05;

import java.util.UUID;

public class DeliveryService {
    // region Fields

    private static final DeparturePoint[] DEPARTURE_POINTS = {
            new DeparturePoint(1, "Donetska", "Kramatorsk", "Nezalezhnosti avenue", "14"),
            new DeparturePoint(2, "Donetska", "Kramatorsk", "Vasylya Stusa street", "35"),
            new DeparturePoint(3, "Donetska", "Mariupol", "Metalurhiv avenue", "75a"),
            new DeparturePoint(4, "Donetska", "Mariupol", "Hretska street", "43"),
            new DeparturePoint(5, "Donetska", "Pokrovsk", "Tarasa Shevchenka street", "26"),
            new DeparturePoint(6, "Kharkivska", "Kharkiv", "Heroiiv Kharkova avenue", "41"),
            new DeparturePoint(7, "Kharkivska", "Kharkiv", "Pavlivska square", "2"),
            new DeparturePoint(8, "Kharkivska", "Kharkiv", "Sumska street", "3") };

    private Shipment[] shipments = new Shipment[]{ };

    // endregion

    // region Methods

    public void createShipment(final int departurePointNumber, final ReceivePoint receivePoint,
                               final ShipmentMethods method, final Item item) {
        final DeparturePoint departurePoint = DEPARTURE_POINTS[departurePointNumber - 1];

        if (departurePoint.equals(receivePoint)) {
            throw new IllegalArgumentException("Points cannot be the same.");
        }

        for (final DeparturePoint point : DEPARTURE_POINTS) {
            if (receivePoint.equals(point)) {
                final Shipment shipment = new Shipment(departurePoint, point, method, item);
                this.addShipment(shipment);

                return;
            }
        }

        final Shipment shipment = new Shipment(departurePoint, receivePoint, ShipmentMethods.BY_BICYCLE, item);
        this.addShipment(shipment);
    }

    public void cancelShipment(final int shipmentNumber) {
        UUID shipmentId = this.shipments[shipmentNumber - 1].getId();
        final int shipmentsNumber = this.shipments.length;
        final Shipment[] newShipments = new Shipment[shipmentsNumber - 1];

        for (int ii = 0, jj = 0; ii < shipmentsNumber; ii++) {
            if (this.shipments[ii].getId() != shipmentId) {
                newShipments[jj++] = this.shipments[ii];
            }
        }

        this.shipments = newShipments;
    }

    public void displayDeparturePoints() {
        for (final DeparturePoint point : DEPARTURE_POINTS) {
            System.out.println(point);
        }
    }

    public void displayShipments() {
        for (final Shipment shipment : this.shipments) {
            System.out.println(shipment);
        }
    }

    private void addShipment(final Shipment shipment) {
        final int shipmentsNumber = this.shipments.length;
        final Shipment[] newShipments = new Shipment[shipmentsNumber + 1];
        System.arraycopy(this.shipments, 0, newShipments, 0, shipmentsNumber);
        newShipments[shipmentsNumber] = shipment;

        this.shipments = newShipments;
    }

    // endregion
}
