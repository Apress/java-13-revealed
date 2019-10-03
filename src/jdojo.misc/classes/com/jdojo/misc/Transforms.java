// Transforms.java
package com.jdojo.misc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import static java.util.stream.Collectors.joining;

public class Transforms {
    /**
     * Returns the string after removing blank lines, and leading 
     * and trailing whitespaces from each line. A line with only whitespaces
     * is considered a blank line.
     * @param str The string to be sanitized
     * @return The string after removing blank lines and leading/trailing 
     *         whitespaces from each line.
     */
    public static String sanitizeBlanks(String str) {
        return str.lines()
                .filter(Predicate.not(String::isBlank))
                .map(String::strip)
                .collect(joining("\n"));
    }
    
    /**
     * Adds a line number to each line in the string. 
     * @param str The string to which line numbers are added
     * @return Returns a string by prefixing each line in the string with
     *         the line number.
     */
    public static String addLineNumber(String str) {
        AtomicInteger lineNumber = new AtomicInteger();
        return str.lines()                
                  .map(s-> lineNumber.incrementAndGet() + ":" + s)
                  .collect(joining("\n"));
    }
    
    public static void main(String[] args) {        
        String str = """
                  Upon the moon I fixed my eye,
                     
                     All over the wide lea;
               With quickening pace my horse drew nigh
                       
                   Those paths so dear to me.
                     """;        
        System.out.println("Original string:\n" + str);
        
        String newStr = str.transform(Transforms::sanitizeBlanks)
                           .transform(Transforms::addLineNumber);       
       System.out.println("The string after transformations:\n" + newStr);

       /* Alternative to using the transform() method of the String class
       String str1 = Transforms.sanitizeBlanks(str);
       String str2 = Transforms.addLineNumber(str1);
       System.out.println("\nThe string after transformations:\n" + str2);
       */
    }
}
