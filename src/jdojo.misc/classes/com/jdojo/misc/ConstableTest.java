// ConstableTest.java
package com.jdojo.misc;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

public class ConstableTest {
    public static void main(String[] args) {
        String str1 = "Hello, JVM Constants API";
        
        // The Optional in desc contains the string itself (str1)
        Optional<String> desc = str1.describeConstable();
        String str2  = desc.get();
        
        // str3 contains the string itself (str1)
        String str3 = str1.resolveConstantDesc(MethodHandles.lookup());
        
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str2 == str3: " + (str2 == str3)); 
    }
}
