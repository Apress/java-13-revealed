// Drive.java
package com.jdojo.enhancedswitch;

public class Drive {
    public static void main(String[] args) {
        for (TrafficLight light : TrafficLight.values()) {
            changeLight(light);
        }
    }

    public static void changeLight(TrafficLight light) {
        String decision = switch (light) {
            case GREEN-> "GO";
            case RED-> "STOP";     
        };
 
        System.out.println(light + ": " + decision);
    }
}
