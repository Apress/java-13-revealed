// SwitchSyntaxComparision.java
package com.jdojo.enhancedswitch;

public class SwitchSyntaxComparision {

    public static void main(String[] args) {
        System.out.println("Using traditional switch:");
    }

    public void traditionalSwitch(int count) {        
        switch (count) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("Out-of-range");
        }
    }

    public void enhancedSwitch(int count) {
        switch (count) {
            case 1->
                System.out.println("One");
            case 2->
                System.out.println("Two");
            case 3->
                System.out.println("Three");
            default->
                System.out.println("Out-of-range");
        }
    }
}
