// Test.java
package com.jdojo.sourcecode.mode;

public class Test {        
    public static void main(String[] args) {       
        Class<Test> cls = Test.class;
        var loader = cls.getClassLoader();
        String mname = loader.getClass().getModule().getName();
        System.out.println("Clas loader: " + loader + "\nModule name: " + mname);
    }
}

