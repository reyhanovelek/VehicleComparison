package org.fleet;

/**
 * Vehicle class that implements Comparable to sort by year descending (newest first).
 */
public class Vehicle implements Comparable<Vehicle> {

    private final String brand;
    private final int year;
    private final double price;

    public Vehicle(String brand, int year, double price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
    public double getPrice() {
       return price;
    }

    /**
     * Natural order: sort by year (newest to oldest).
     */
    @Override
    public int compareTo(Vehicle other) {
        return Integer.compare(other.year, this.year); // Newest first
    }

    @Override
    public String toString() {
        return brand + " (" + year + ") - $ " + price;
    }
}