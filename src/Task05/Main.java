/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "Main.java" file */

package Task05;

public class Main {
    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();

        final ReceivePoint point1 = new ReceivePoint("Donetska", "Kramatorsk", "Nezalezhnosti avenue", "14");
        final ReceivePoint point2 = new ReceivePoint("Donetska", "Bakhmut", "Svobody street", "20");

        final Item item1 = new Item(4d, 7d);
        final Item item4 = new Item(32d, 50d);

        System.out.println("[Departure points]");
        service.displayDeparturePoints();

        System.out.println("\n[Must be an exception: points cannot be the same]");
        try {
            service.createShipment(1, point1, ShipmentMethods.BY_BICYCLE, item1);
        } catch (final IllegalArgumentException ex) {
            System.out.println("\n" + ex.getMessage());
        }

        service.createShipment(2, point1, ShipmentMethods.BY_BICYCLE, item1);
        System.out.println("\n[Must be 1 shipment: by bicycle]\n");
        service.displayShipments();

        service.cancelShipment(1);
        System.out.println("[Must be no shipment]\n");
        service.displayShipments();

        service.createShipment(1, point2, ShipmentMethods.BY_BUS, item1);
        service.createShipment(4, point1, ShipmentMethods.BY_TRUCK, item4);
        System.out.println("[Must be 2 shipments: by bicycle, by truck]\n");
        service.displayShipments();

        System.out.println("[Must be an exception: the item is too heavy or too big.]");
        try {
            service.createShipment(5, point1, ShipmentMethods.BY_BICYCLE, item4);
        } catch (final IllegalArgumentException ex) {
            System.out.println("\n" + ex.getMessage());
        }
    }
}
