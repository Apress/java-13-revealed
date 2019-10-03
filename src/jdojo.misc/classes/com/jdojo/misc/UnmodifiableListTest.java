// UnmodifiableListTest.java
package com.jdojo.misc;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class UnmodifiableListTest {
    public static void main(String[] args) {
        // Create a modifiable list
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Buddy");
        names.add("Vishwa");
        names.add("Amy");

        // Copy the modifiable list into an unmodifiable list
        List<String> namesCopy = List.copyOf(names);

        // Print both lists
        System.out.println("\nAfter copying the original list:");
        System.out.println("names: " + names);
        System.out.println("namesCopy: " + namesCopy);

        // Let us add a name to the modifiable list
        names.add("Mamta");

        // Print both lists
        System.out.println("\nAfter adding a name to the original list:");
        System.out.println("names: " + names);
        System.out.println("namesCopy: " + namesCopy);

        // Let us try sorting the unmodifiable list
        try {
            namesCopy.sort(Comparator.naturalOrder());
            System.out.println("\nSorted namesCopy: " + namesCopy);
        } catch (Exception e) {
            System.out.println("\nCannot sort an unmodifiable list");
        }
    }
}
