// PrintMyIP.java
package com.jdojo.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class PrintMyIP {
    public static void main(String[] args) {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();

        // Create an HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://httpbin.org/ip"))
                .build();

        try {
            // Send the request to the server
            HttpResponse<String> response
                    = client.send(request, BodyHandlers.ofString());

            // Get the response status and body
            int statusCode = response.statusCode();
            String body = response.body();

            // Print the response status and body
            System.out.println("Response Status: " + statusCode);
            System.out.println("Response body:\n" + body);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
