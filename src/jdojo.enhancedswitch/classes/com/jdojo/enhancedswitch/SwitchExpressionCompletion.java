// SwitchExpressionCompletion.java
package com.jdojo.enhancedswitch;

import java.time.LocalDate;

public class SwitchExpressionCompletion {
    public static void main(String[] args) {
        int count = 2;     
        
        // Uncomment the following switch expression
        // and compile the class to see the compile-time erros
        /*
        String desc = switch(count) {
            case 1-> "One";
            case 2-> throw new IllegalArgumentException("Don't like two!");                 
            case 3-> {
                if (LocalDate.now().getYear() == 2019) {
                    yield "Three";
                }                
                // A compile-time error
            }
            default-> {
                System.out.println("What are you talking about!");
                // A compile-time error
            }
        };
        */
    }
}
