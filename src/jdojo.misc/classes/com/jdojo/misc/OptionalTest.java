// OptionalTest.java
package com.jdojo.misc;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Kishori Sharan");
        String fn1 = name.orElseThrow(
            () -> new NoSuchElementException("No value present"));
        String fn2 = name.orElseThrow();

        System.out.println("fn1: " + fn1);
        System.out.println("fn2: " + fn2);

        try {
            Optional<String> phone = Optional.empty();
            String f2 = phone.orElseThrow();
        } catch (NoSuchElementException e) {
            System.out.println("Phone: " + e.getMessage());
        }

        // Have a list of Optional<String>
        List<Optional<String>> list = List.of(Optional.empty(),
                Optional.of("Kishori"),
                Optional.empty(),
                Optional.of("Sharan"),
                Optional.empty());

        // Count the empty Optionals in the list
        long emptyCount = list.stream()
                .filter(Optional::isEmpty)
                .count();
        System.out.println("Empty name count: " + emptyCount);
    }
}
