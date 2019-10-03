// FilesTest.java
package com.jdojo.misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesTest {
    public static void main(String[] args) throws IOException {
        // Two files and their contents
        String text1 = "Hello, Text1";
        String text2 = "Hello, Text2";
        Path file1 = Paths.get("greeting1.txt");
        Path file2 = Paths.get("greeting2.txt");

        // Ensure test files exist. If they do not exist, create them.
        createTestFile(file1, text1);
        createTestFile(file2, text2);

        printMismatch(file1, file2);
        printMismatch(file1, file1);
    }

    public static void createTestFile(Path file, String text)
            throws IOException {
        Path absPath = file.toAbsolutePath();
        if (Files.exists(file) && Files.isRegularFile(file)) {
            System.out.printf("Information: %s exists.%n", absPath);
        } else {
            // Write the text to the file
            System.out.printf("Created %s.%n", absPath);
            Files.writeString(file, text);
        }

        // Print the contents of the file
        String str = Files.readString(file);
        System.out.printf("%s contains:%n%s%n", absPath, str);
    }

    public static void printMismatch(Path file1, Path file2)
            throws IOException {
        long pos = Files.mismatch(file1, file2);
        if (pos == -1L) {
            System.out.printf("%s and %s matched.%n",
                    file1.toAbsolutePath(), file2.toAbsolutePath());
        } else {
            System.out.printf("%s and %s mismatched at position %d.%n",
                    file1.toAbsolutePath(), file2.toAbsolutePath(), pos);
        }
    }
}
