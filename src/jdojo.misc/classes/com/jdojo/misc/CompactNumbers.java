// CompactNumbers.java
package com.jdojo.misc;

import java.text.NumberFormat;
import java.util.Locale;
import static java.text.NumberFormat.Style.LONG;
import static java.text.NumberFormat.Style.SHORT;

public class CompactNumbers {
    public static void main(String[] args) {
        printCompact(24000, Locale.US);
        printCompact(1969, Locale.US);
        
        printCompact(24000, Locale.GERMANY);
        printCompact(1969, Locale.GERMANY);
        
        Locale hindiIndia = new Locale("hi", "IN");
        printCompact(24000, hindiIndia);
        printCompact(1969, hindiIndia);
    }

    public static void printCompact(int num, Locale locale) {
        NumberFormat shortFormatter
                = NumberFormat.getCompactNumberInstance(locale, SHORT);
        NumberFormat longFormatter
                = NumberFormat.getCompactNumberInstance(locale, LONG);
        String shortStr = shortFormatter.format(num);
        String longStr = longFormatter.format(num);
        System.out.printf("%s: %d, %s, %s%n", 
            locale, num, shortStr, longStr);
    }
}
