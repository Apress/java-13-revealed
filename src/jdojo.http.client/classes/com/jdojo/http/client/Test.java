// Test.java
package com.jdojo.http.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class Test {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        
        String uriStr = "http://google.com";
        
        // Create an HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriStr))
                    .build(); 

         // Send the request to the server
         HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println(response.body());
      
        
    }   
}
