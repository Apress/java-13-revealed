// AsynchronousRequest.java
package com.jdojo.http.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class AsynchronousRequest {
    public static void main(String[] args) {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();

        // Use the Get HTTP method
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://httpbin.org/ip"))
                .build();

        // Send the request asynchronously and print the response body
        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
