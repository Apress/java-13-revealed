// Stats.java
package com.jdojo.sourcecode.mode;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import static java.util.stream.Collectors.summarizingDouble;

public class Stats {
    public static void main(String[] args) {
        if (args.length == 0) {
            out.println("No numbers were specified.");
            out.println("Usage: Prints stats of the specified numbers "
                    + "such as sum, average, min, and max.");
            out.println("Syntax: java Stats.java [numbers]");
            out.println("Example: java Stats.java 10 20 25 34");
            return;
        }

        // Compute and print the stats on the agruments 
        DoubleSummaryStatistics stats = Arrays.asList(args)
                .stream()
                .map(s -> Double.valueOf(s))
                .collect(summarizingDouble(Double::doubleValue));

        out.println(stats);
    }
}
