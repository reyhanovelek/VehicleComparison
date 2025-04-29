package org.fleet;

import java.util.Comparator;

/**
 * Comparator to sort vehicles by price in ascending order.
 */
public class VehiclePriceComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle v1, Vehicle v2) {
    return Double.compare(v1.getPrice(), v2.getPrice());
    }
}
