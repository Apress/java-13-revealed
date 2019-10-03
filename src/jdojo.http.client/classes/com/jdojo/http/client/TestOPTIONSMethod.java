// TestOPTIONSMethod.java
package com.jdojo.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class TestOPTIONSMethod {
    public static void main(String[] args) {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();

        // Create an HttpRequest        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://httpbin.org/post"))                
                .method("OPTIONS", BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response
                    = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Get the response status and body
            int statusCode = response.statusCode();
            String body = response.body();
            Map<String,List<String>> headers = response.headers().map();

            // Print the response status and body
            System.out.println("Response Status: " + statusCode);
            System.out.println("Response headers:\n" + headers);
            System.out.println("Response body:\n" + body);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
