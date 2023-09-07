/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #01,
 * Task #05,
 * "Shipment.java" file */

package Task05;

import java.util.UUID;

public class Shipment {
    // region Fields

    public final UUID id;
    private final DeparturePoint _fromPoint;
    public final IPoint toPoint;
    private final Item _item;
    private final ShipmentMethods _method;

    // endregion

    // region Constructors

    public Shipment(final DeparturePoint fromPoint, final IPoint toPoint, final ShipmentMethods method,
                    final Item item) {
        switch (method) {
            case BY_BICYCLE -> {
                final double byBicycleMaxWeight = 5d;
                final double byBicycleMaxVolume = 10d;

                if (item.weight > byBicycleMaxWeight || item.volume > byBicycleMaxVolume)
                    throw new IllegalArgumentException("The item is too heavy or too big.");
            }
            case BY_BUS -> {
                final double byBusMaxWeight = 20d;
                final double byBusMaxVolume = 30d;

                if (item.weight > byBusMaxWeight || item.volume > byBusMaxVolume)
                    throw new IllegalArgumentException("The item is too heavy or too big.");
            }
            case BY_TRAIN -> {
                final double byTrainMaxWeight = 50d;
                final double byTrainMaxVolume = 100d;

                if (item.weight > byTrainMaxWeight || item.volume > byTrainMaxVolume)
                    throw new IllegalArgumentException("The item is too heavy or too big.");
            }
            case BY_TRUCK -> {
                final double byTruckMaxWeight = 40d;
                final double byTruckMaxVolume = 60d;

                if (item.weight > byTruckMaxWeight || item.volume > byTruckMaxVolume)
                    throw new IllegalArgumentException("The item is too heavy or too big.");
            }
        }

        this.id = UUID.randomUUID();
        this._fromPoint = fromPoint;
        this.toPoint = toPoint;
        this._item = item;
        this._method = method;
    }

    // endregion

    // region Methods

    @Override
    public String toString() {
        return String.format("""
                (from) %s
                (to) %s
                (method) %s
                (item weight) %s kg
                (item volume) %s vol. value
                """,
                this._fromPoint.toString(), this.toPoint.toString(),
                switch (this._method) {
                    case BY_BICYCLE -> "by bicycle";
                    case BY_BUS -> "by bus";
                    case BY_TRAIN -> "by train";
                    case BY_TRUCK -> "by truck";
                },
                String.format("%,.2f", this._item.weight), String.format("%,.2f", this._item.volume));
    }

    // endregion
}

