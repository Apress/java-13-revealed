// CLTest4.java
package com.jdojo.sourcecode.mode;

public class CLTest4 {
    public static void main(String[] args) {
        FruitsPrinter.print();
    }
}

public class FruitsPrinter {
    static {
        // Print the class loader for this class
        var cl = FruitsPrinter.class.getClassLoader();
        System.out.println("FruitsPrinter class in source file" + 
                " was loaded by " + cl);
    }
    
    public static void print() {         
        System.out.println("FruitsPrinter.print() in source file called.");
        Fruits.print();
    }
}

public class Fruits {
    static {
        // Print the class loader for this class
        var cl = Fruits.class.getClassLoader();
        System.out.println("Fruits class in source file"
                + " was loaded by " + cl);
    }

    public static void main(String[] args) {
        Fruits.print();
    }

    public static void print() {
        System.out.println("Fruits in source file: Watermelons");
    }
}