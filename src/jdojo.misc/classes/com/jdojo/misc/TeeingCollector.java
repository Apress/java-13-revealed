// TeeingCollector.java
package com.jdojo.misc;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.teeing;

public class TeeingCollector {
    public static void main(String[] args) {
        // Concatenate names in the list separating them with a comma and 
        // and count the number of names in the final string
        String displayText = List.of("Buddy", "John", "Lisa")
              .stream()
              .collect(teeing(joining(","),
                              counting(),
                              (names, count) -> names + "\nTotal:" + count));

        System.out.println(displayText);
        
        // Compute sum and average of doubles and collect the two results
        // into a Map.Entry in which key is the sum and value is the average
        Map.Entry<Double, Double> stat = List.of(10.0, 20.0, 30.0, 40.0)
                .stream()
                .collect(teeing(summingDouble(x -> x.doubleValue()),
                                averagingDouble(n -> n),
                                Map::entry));

        System.out.printf("sum: %f, average: %f%n",
                stat.getKey(), stat.getValue());
    }
}
