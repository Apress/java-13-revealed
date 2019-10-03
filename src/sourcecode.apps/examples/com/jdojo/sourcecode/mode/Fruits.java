// Fruits.java
package com.jdojo.sourcecode.mode;

public class Fruits {
    static {
        // Print the class loader for this class
        var cl = Fruits.class.getClassLoader();
        System.out.println("Fruits class on class path" + 
                " was loaded by " + cl);
    }
    
    public static void print() {         
        System.out.println("Fruits on class path: "
                + "Oranges, Papayas, Apples");
    }
}