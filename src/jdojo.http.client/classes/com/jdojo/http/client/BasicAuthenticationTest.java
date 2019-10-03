// BasicAuthenticationTest.java
package com.jdojo.http.client;

import java.net.Authenticator;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class BasicAuthenticationTest {    
    public static void main(String[] args) {
        // Set a default authenticator
        String username = "kishori";
        char[] password = new char[]{'s', 'h', 'a', 'r', 'a', 'n'};
        Authenticator.setDefault(
                new BasicAuthenticator(username, password));

        // Create an HttpClient with an authenticator
        HttpClient client = HttpClient.newBuilder()                
                .authenticator(Authenticator.getDefault())
                .build();

        // Use the Get HTTP method
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/basic-auth/" 
                        + username + "/" + new String(password)))                
                .build();

        // Send the request to the server asynchronously
        HttpResponse<String> response
                = client.sendAsync(request, BodyHandlers.ofString())
                        .join();

        // Print the response status and body
        System.out.println("Response Status: " + response.statusCode());
        System.out.println("Response body:\n" + response.body());
        
        // Print the previous response details
        response.previousResponse()
                .ifPresent(previousResopnse -> {
                    System.out.println("Previous response Status: "
                            + previousResopnse.statusCode());
                    System.out.println("Previous response body:\n"
                            + previousResopnse.body());
                    
                    System.out.println("Previous response headers:");
                    previousResopnse.headers()
                            .map()
                            .entrySet()
                            .forEach(System.out::println);
                });
    }
}
