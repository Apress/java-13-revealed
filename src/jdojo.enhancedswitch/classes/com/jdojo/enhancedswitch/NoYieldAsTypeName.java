// NoYieldAsTypeName.java
package com.jdojo.enhancedswitch;

public class NoYieldAsTypeName {
    public static void main(String[] args) {
        // Must qualify with the class name to call the yield() methods
        NoYieldAsTypeName.yield();        
        NoYieldAsTypeName.yield(100);
        
        // The following unqualified calls generates compile-time error
        //yield();
        //yield(10);
        
        int yield = 200;
        System.out.println("Variable name yield is okay: " + yield);
    }
    
    public static void yield() {
        System.out.println("Method name yield is okay.");
    }
    
    public static void yield(int x) {
        System.out.println("Method name yield is okay: " + x);
    }
}
