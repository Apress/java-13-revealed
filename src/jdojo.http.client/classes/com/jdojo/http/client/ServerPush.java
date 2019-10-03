// ServerPush.java
package com.jdojo.http.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import static java.net.http.HttpClient.Redirect.ALWAYS;

public class ServerPush {
    public static void main(String[] args) {
        // Create an HttpClient to allow redirects
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(ALWAYS)
                .build();

        // Build a request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.angular.io"))
                .build();

        // Send the request asynchronously allowing server push
        HttpResponse<String> response = client.sendAsync(request,
                BodyHandlers.ofString(),
                new ServerPushPromiseHandler()
        ).join();

        // Print the response details
        System.out.printf("Initiating request URI: %s%n"
                + "Response's request URI: %s%n"
                + "Response status code: %d%n",
                request.uri(), 
                response.request().uri(), 
                response.statusCode());

        try {
            // Wait for five seconds to let the push promises finish
            // If you do not see output related to push promises 
            // responses, increase the wait time, maybe to 10 seconds.
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
