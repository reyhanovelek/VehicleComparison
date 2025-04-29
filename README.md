📚 STUDENT EXERCISE: Vehicle Comparison System
🚗 Theme: "Manage a fleet of vehicles and sort them"
Students will create a Vehicle class, sort vehicles naturally by year (newest first) and by brand name alphabetically using a custom comparator.
They will print the vehicles nicely using forEach(System.out::println), and test sorting with JUnit 5.

🛠️ Full Step-by-Step Guide
1️⃣ Setup: Create a Maven Project
Open IntelliJ IDEA → New Project → Maven.
Fill in:
GroupId: org.fleet
ArtifactId: VehicleComparison
Version: (leave default)
✅ Click Finish → IntelliJ creates your project.

2️⃣ Fix pom.xml to Use JUnit 5
Replace any old dependency with:

<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.9.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
✅ Save and let Maven download JUnit 5 automatically.

3️⃣ Create Packages and Classes
Inside src/main/java/org/fleet/:

✅ Create these 3 files:

File	Purpose
Vehicle.java	Vehicle class implementing Comparable
VehicleBrandComparator.java	Custom comparator to sort by brand
VehicleApp.java	main() app to demonstrate sorting
4️⃣ Implement Vehicle.java
package org.fleet;

/**
 * Vehicle class that implements Comparable to sort by year descending (newest first).
 */
public class Vehicle implements Comparable<Vehicle> {

    private final String brand;
    private final int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
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
        return brand + " (" + year + ")";
    }
}
✅ Vehicle naturally sorts by year, newest vehicles first.

5️⃣ Implement VehicleBrandComparator.java
package org.fleet;

import java.util.Comparator;

/**
 * Comparator to sort vehicles alphabetically by brand name.
 */
public class VehicleBrandComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v1.getBrand().compareToIgnoreCase(v2.getBrand());
    }
}
✅ This allows sorting alphabetically by brand.

6️⃣ Implement VehicleApp.java
package org.fleet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleApp {

    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Vehicle("Toyota", 2021));
        fleet.add(new Vehicle("Ford", 2018));
        fleet.add(new Vehicle("BMW", 2022));
        fleet.add(new Vehicle("Honda", 2020));

        System.out.println("Original Fleet:");
        fleet.forEach(System.out::println);

        // Sort by year (natural)
        Collections.sort(fleet);
        System.out.println("\nSorted by Year (Newest First):");
        fleet.forEach(System.out::println);

        // Sort by brand name
        fleet.sort(new VehicleBrandComparator());
        System.out.println("\nSorted by Brand (Alphabetical):");
        fleet.forEach(System.out::println);
    }
}
✅ Demonstrates sorting by both year and brand name.
✅ Prints nicely using forEach(System.out::println).

7️⃣ Write JUnit 5 Tests
Inside src/test/java/org/fleet/:

✅ Create VehicleTest.java

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
        fleet.add(new Vehicle("Toyota", 2021));
        fleet.add(new Vehicle("Ford", 2018));
        fleet.add(new Vehicle("BMW", 2022));
        fleet.add(new Vehicle("Honda", 2020));
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
✅ One test for year sorting,
✅ One test for brand sorting.

📋 Final Submission Requirements for Students
✅ Correct Maven project structure
✅ Vehicle, VehicleBrandComparator, VehicleApp, VehicleTest
✅ Proper usage of Comparable, Comparator, and forEach(System.out::println)
✅ Tests passing with green bar in IntelliJ or Maven.

📚 Key Concepts Students Will Practice
Concept	Practice
Comparable	Natural sort by year
Comparator	Custom sort by brand
Method References	Printing with System.out::println
Collections API	Sorting lists
JUnit 5	Writing clear, readable tests
Maven	Professional project structure
🎯 Bonus Challenges (Optional)
Add more fields to Vehicle (e.g., price) and sort by price.
Create a multi-level comparator (sort by year, then brand if tie).
Format the console output nicer (aligned columns).
