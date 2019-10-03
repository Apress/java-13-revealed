// FruitsPrinter.java
package com.jdojo.sourcecode.mode;

public class FruitsPrinter {
    static {
        // Print the class loader for this class
        var cl = FruitsPrinter.class.getClassLoader();
        System.out.println("FruitsPrinter class on class path" + 
                " was loaded by " + cl);
    }
    
    public static void print() {         
        System.out.println("FruitsPrinter.print() on class path called.");
        Fruits.print();
    }
}