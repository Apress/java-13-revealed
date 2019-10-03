// Laptop.java
package com.jdojo.sourcecode.mode;

public class Laptop {    
    private Configuration config;
    public Laptop(Configuration config) {
        this.config = config;
    }
    
    public static void main(String[] args) {       
        Configuration config = new Configuration();
        Laptop laptop = new Laptop(config);
        System.out.println("Created a laptop...");
    }
}

public class Configuration {
    public Configuration() {
        System.out.println("Creating a default configuration...");
    }
}
