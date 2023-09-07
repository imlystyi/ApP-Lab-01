/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "DeliveryService.java" file */

package Task05;

public class DeliveryService {
    // region Fields

    public final DeparturePoint[] departurePoints =
            {
            new DeparturePoint(1, "Donetska", "Kramatorsk", "Nezalezhnosti avenue", "14"),
            new DeparturePoint(2, "Donetska", "Kramatorsk", "Vasylya Stusa street", "35"),
            new DeparturePoint(3, "Donetska", "Mariupol", "Metalurhiv avenue", "75a"),
            new DeparturePoint(4, "Donetska", "Mariupol", "Hretska street", "43"),
            new DeparturePoint(5, "Donetska", "Pokrovsk", "Tarasa Shevchenka street", "26"),
            new DeparturePoint(6, "Kharkivska", "Kharkiv", "Heroiiv Kharkova avenue", "41"),
            new DeparturePoint(7, "Kharkivska", "Kharkiv", "Pavlivska square", "2"),
            new DeparturePoint(8, "Kharkivska", "Kharkiv", "Sumska street", "3")
            };

    private Shipment[] shipments = new Shipment[] {};

    // endregion

    // region Methods

    public void addShipment(final int departurePointNumber, final ReceivePoint receivePoint,
                            final ShipmentMethods method, final Item item) {
        final DeparturePoint departurePoint = this.departurePoints[departurePointNumber];

        if (departurePoint.oblast.equals(receivePoint.oblast) &&
                departurePoint.city.equals(receivePoint.city) &&
                departurePoint.street.equals(receivePoint.street) &&
                departurePoint.building.equals(receivePoint.building))
            throw new IllegalArgumentException("Points cannot be the same.");

        for (final DeparturePoint point: this.departurePoints) {
            if (point.oblast.equals(receivePoint.oblast) &&
                    point.city.equals(receivePoint.city) &&
                    point.street.equals(receivePoint.street) &&
                    point.building.equals(receivePoint.building))
            {
                this.shipments = departurePoint.createShipment(this.shipments, point, method, item);

                return;
            }
        }

        this.shipments = departurePoint.createShipment(this.shipments, receivePoint, ShipmentMethods.BY_BICYCLE, item);
    }

    public void cancelShipment(final int departurePointNumber, final int shipmentNumber) {
        final Shipment shipment = this.shipments[shipmentNumber - 1];
        final DeparturePoint departurePoint = this.departurePoints[departurePointNumber];

        this.shipments = departurePoint.cancelShipment(this.shipments, shipment.toPoint, shipment.id);
    }

    public void displayDeparturePoints() {
        for (final DeparturePoint point: this.departurePoints)
            System.out.println(point.toString());
    }

    public void displayShipments() {
        for (final Shipment shipment: this.shipments)
            System.out.println(shipment.toString());
    }

    // endregion
}
