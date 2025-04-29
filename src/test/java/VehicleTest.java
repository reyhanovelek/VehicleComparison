package org.fleet;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private List<Vehicle> fleet;

    @BeforeEach
    void setUp() {
        fleet = new ArrayList<>();
        fleet.add(new Vehicle("Toyota", 2021,22000));
        fleet.add(new Vehicle("Ford", 2018,15000));
        fleet.add(new Vehicle("BMW", 2022,40000));
        fleet.add(new Vehicle("Honda", 2020,18000));
    }

    @Test
    @DisplayName("Vehicles should sort by year (newest first)")
    void testSortByYear() {
        Collections.sort(fleet);

        assertEquals("BMW", fleet.get(0).getBrand());
        assertEquals("Toyota", fleet.get(1).getBrand());
        assertEquals("Honda", fleet.get(2).getBrand());
        assertEquals("Ford", fleet.get(3).getBrand());
    }

    @Test
    @DisplayName("Vehicles should sort by brand name alphabetically")
    void testSortByBrand() {
        fleet.sort(new VehicleBrandComparator());

        assertEquals("BMW", fleet.get(0).getBrand());
        assertEquals("Ford", fleet.get(1).getBrand());
        assertEquals("Honda", fleet.get(2).getBrand());
        assertEquals("Toyota", fleet.get(3).getBrand());
    }
}
