// SaveInFile.java
package com.jdojo.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveInFile {
    public static void main(String[] args) {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();

        // Use the Get HTTP method
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://httpbin.org/image/jpeg"))
                .build();

        try {
            // Create a Path to save the image in a file named myimage.jpg
            // in the current directory
            Path filePath = Paths.get("myimage.jpeg");

            // Set the request to the server
            HttpResponse<Path> response
                    = client.send(request, BodyHandlers.ofFile(filePath));

            // Get the response status and body
            int statusCode = response.statusCode();
            Path savedFilePath = response.body();
            
            // Print the response status and body
            System.out.println("Response Status: " + statusCode);
            System.out.println("Response body was saved at " 
                    + savedFilePath.toAbsolutePath());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
