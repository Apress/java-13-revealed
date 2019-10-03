// PrintHeaders.java
package com.jdojo.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class PrintHeaders {
    public static void main(String[] args) {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();

        // Create an HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://httpbin.org"))
                .method("HEAD", BodyPublishers.noBody())
                .build();
        try {
            // send the request to the server
            HttpResponse<Void> response
                    = client.send(request, BodyHandlers.discarding());

            // Print the response status code and headers
            System.out.println("Status Code:" + response.statusCode());

            System.out.println("Response Headers:");
            response.headers()
                    .map()
                    .entrySet()
                    .forEach(System.out::println);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
