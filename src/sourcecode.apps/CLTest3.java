// CLTest3.java
package com.jdojo.sourcecode.mode;

public class CLTest3 {
    public static void main(String[] args) {
        FruitsPrinter.print();
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
        System.out.println("Fruits on source file: Watermelons");
    }
}