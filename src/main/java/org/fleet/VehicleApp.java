package org.fleet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleApp {

    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Vehicle("Toyota", 2021, 22000));
        fleet.add(new Vehicle("Ford", 2018,15000));
        fleet.add(new Vehicle("BMW", 2022,40000));
        fleet.add(new Vehicle("Honda", 2020,18000));

        System.out.println("Original Fleet:");
        System.out.println("Brand      | Year | Price");
        System.out.println("-----------------------------");
        fleet.forEach(v -> System.out.printf("%-10s | %4d | $%.2f\n", v.getBrand(), v.getYear(), v.getPrice()));


        // Sort by year (natural)
        Collections.sort(fleet);
        System.out.println("\nSorted by Year (Newest First):");
        System.out.println("Brand      | Year | Price");
        System.out.println("-----------------------------");
        fleet.forEach(v -> System.out.printf("%-10s | %4d | $%.2f\n", v.getBrand(), v.getYear(), v.getPrice()));


        // Sort by brand name
        fleet.sort(new VehicleBrandComparator());
        System.out.println("\nSorted by Brand (Alphabetical):");
        System.out.println("Brand      | Year | Price");
        System.out.println("-----------------------------");
        fleet.forEach(v -> System.out.printf("%-10s | %4d | $%.2f\n", v.getBrand(), v.getYear(), v.getPrice()));

        //Sort by price
        fleet.sort(new VehiclePriceComparator());
        System.out.println("\nSorted by Price (Lowest First):");
        System.out.println("Brand      | Year | Price");
        System.out.println("-----------------------------");
        fleet.forEach(v -> System.out.printf("%-10s | %4d | $%.2f\n", v.getBrand(), v.getYear(), v.getPrice()));

    }
}