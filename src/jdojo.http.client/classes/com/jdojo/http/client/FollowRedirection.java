// FollowRedirection.java
package com.jdojo.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import static java.net.http.HttpClient.Redirect.NORMAL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import static java.nio.charset.StandardCharsets.UTF_8;

public class FollowRedirection {
    public static void main(String[] args) {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();

        // Location of the new URL
        String location = "http://httpbin.org/ip";

        // Prepare the URL that will redirect the request to a new location
        String uriStr = "http://httpbin.org/redirect-to?"
                + "url=" + URLEncoder.encode(location, UTF_8)
                + "&status_code=301";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriStr))
                .build();

        // Send the request with the default redirection policy of NEVER.
        // Expecting a response with a status code 301.
        printResponse(client, request);

        System.out.println("-----------------------------------");

        // Create an HTTPClient with a redirection policy of NORMAL
        client = HttpClient.newBuilder()
                .followRedirects(NORMAL)
                .build();

        // Send the request with the redirection policy of NORMAL
        // Expecting a response with a status code 200
        printResponse(client, request);
    }

    public static void printResponse(HttpClient client,
            HttpRequest request) {
        try {
            HttpResponse<String> response
                    = client.send(request, BodyHandlers.ofString());

            // Get the response status and body
            int statusCode = response.statusCode();
            String body = response.body();
            String locationHeader = response.headers()
                    .firstValue("Location")
                    .orElse("");

            System.out.println("Status code: " + statusCode);
            System.out.println("Location Header: " + locationHeader);
            System.out.println("Response body:\n" + body);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
