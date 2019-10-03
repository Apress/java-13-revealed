package com.jdojo.typeinference;

import java.util.Optional;
import java.util.function.BiFunction;
//import org.checkerframework.checker.nullness.qual.*;


public class Test {    
     public static void main(String[] args) {
        BiFunction<Integer,Long,Double> avg = (final var n1, final var n2) -> (n1 + n2)/2.0;
        
        
        System.out.println("\nAvarage of 10 and 20 is " + avg.apply(10, 20L));
     }
}
