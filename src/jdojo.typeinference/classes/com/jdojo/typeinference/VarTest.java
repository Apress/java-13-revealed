// VarTest.java
package com.jdojo.typeinference;

import java.util.List;
import java.util.Arrays;
import java.util.function.BiFunction;

public class VarTest {
    public static void main(String[] args) {
        // The inferred type of personId is int
        var personId = 1001;
        System.out.println("personID = " + personId);

        // The inferred type of prompt is String
        var prompt = "Enter a message:";
        System.out.println("prompt = " + prompt);

        // You can use methods of the String class on prompt as you did 
        // when you declared it as "String prompt = ..."
        System.out.println("prompt.length() = " + prompt.length());
        System.out.println("prompt.substring(0, 5) = "
                + prompt.substring(0, 5));

        // Use an explicit type name, double
        double salary = 1878.89;
        System.out.println("salary = " + salary);

        // The inferred type of luckyNumbers is List<Integer>
        var luckyNumbers = List.of(9, 19, 1969);
        System.out.println("luckyNumbers = " + luckyNumbers);

        // The inferred type of cities is String[]
        var cities = new String[]{"Altanta", "Patna", "Paris", "Gaya"};
        System.out.println("cities = " + Arrays.toString(cities));
        System.out.println("cities.getClass() = " + cities.getClass());

        System.out.println("\nList of cities using a for loop:");

        // The inferred type of the index, i, is int
        for (var i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }

        System.out.println("\nList of cities using a for-each loop:");

        // The inferred type of the index, city, is String
        for (var city : cities) {
            System.out.println(city);
        }

        BiFunction<Integer, Long, Double> avg
                = (var n1, var n2) -> (n1 + n2) / 2.0;
        System.out.println("\nAverage of 10 and 20 is "
                + avg.apply(10, 20L));
    }
}
