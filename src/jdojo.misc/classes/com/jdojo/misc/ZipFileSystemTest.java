// ZipFileSystemTest.java
package com.jdojo.misc;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ZipFileSystemTest {
    public static void main(String[] args) {
        // Path to the zip file that will be used as a file system
        Path path = Paths.get("zipfstest.zip");
        System.out.println("Using Zip File System: " 
                + path.toAbsolutePath());

        // Store the properties of the Zip File System in a Map
        Map<String, String> env = Map.of("create", "true",
                                         "encoding", "UTF-8");

        // Create a Zip File system and use it to write and read a file
        try (FileSystem fs = FileSystems.newFileSystem(path, env)) {
            String fileName = "greeting.txt";

            // Create a file with some text, if the file does not exist.
            createFile(fs, fileName);

            // Read the contents of the file in the zip file
            readFile(fs, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(FileSystem fs, String fileName)
            throws IOException {
        Path filePath = fs.getPath(fileName);
        if (Files.exists(filePath)) {
            System.out.printf("The %s file exists in %s.%n", filePath, fs);
            return;
        }

        // Create a file and add a greeting to the file
        Files.writeString(filePath, "Hello, ZIP File System!");
        System.out.printf("Created a %s file in %s.%n", filePath, fs);
    }

    public static void readFile(FileSystem fs, String fileName)
            throws IOException {
        Path filePath = fs.getPath(fileName);

        // Read the contents of the file
        String text = Files.readString(filePath);
        System.out.printf("Contents of %s:%n%s%n", fileName, text);
    }
}
