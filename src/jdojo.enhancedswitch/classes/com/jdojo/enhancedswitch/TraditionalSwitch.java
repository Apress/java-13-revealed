// TraditionalSwitch.java
package com.jdojo.enhancedswitch;

public class TraditionalSwitch {
    public static void main(String[] args) {
        whatLetter('a');
        whatLetter('W');
        whatLetter('5');
        
        for(int i = 1; i <= 4; i++) {
            String desc = getDesc(i);
            System.out.printf("%d:%s%n", i, desc);
        }
    }
   
    public static void whatLetter(char c) {        
        // Use the traditional switch with multiple constants in a case
        switch(Character.toLowerCase(c)) {
            case 'a', 'e', 'i', 'o', 'u': 
                System.out.println("Vowel: " + c);
                break;
            default:
                if (Character.isLetter(c)) {
                    System.out.println("Consonant: " + c);
                } else {
                    System.out.println("Not-a-Letter: " + c);
                }
        }
    }

    public static String getDesc(int count) {
        // Use the traditional switch as an expression
        return switch (count) {
            case 1: yield "One";
            case 2: yield "Two";
            case 3: yield "Three";
            default: yield "Out-of-range";
        };
    }
}
