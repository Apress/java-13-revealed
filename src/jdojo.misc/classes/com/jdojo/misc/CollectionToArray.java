// CollectionToArray.java
package com.jdojo.misc;

import java.util.Arrays;
import java.util.List;

public class CollectionToArray {
    public static void main(String[] args) {
        // Create a list of strings   
        List<String> names = List.of("Buddy", "John", "Lisa");
        System.out.println("List: " + names);

        // Use the toArray() method to copy list to an Object[]
        Object[] names1 =  names.toArray();
        System.out.println("names1: " + Arrays.toString(names1));

        // Pass a String[] of zero length, so the toArray() method
        // creates a new array of the same size as the list
        String[] names2 = names.toArray(new String[0]);
        System.out.println("names2: " + Arrays.toString(names2));

        // Pass a bigger array to toArray(). The first 3 elements in the
        // array will be overwritten by the elements from the list,
        // the 4th will be set to null, and 5th and 6th will be untouched.
        String[] team = new String[] {"Lu", "Xi", "Ho", "Yo", "To", "Mo"};
        System.out.println("team: " + Arrays.toString(team));

        String[] newTeam = names.toArray(team);
        System.out.println("newTeam: " + Arrays.toString(newTeam));
        System.out.println("team == newTeam: " + (team == newTeam));

        // Use the toArray(IntFunction<T[]> generator) to copy the list
        String[] names3 = names.toArray(String[]::new);
        System.out.println("names3: " + Arrays.toString(names3));
    }
}
