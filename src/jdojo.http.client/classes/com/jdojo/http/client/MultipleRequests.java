// MultipleRequests.java
package com.jdojo.http.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import static java.util.stream.Collectors.toList;

public class MultipleRequests {
    public static void main(String[] args) {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();

        // Collect all URIs in a List
        List<URI> uriList = List.of(
                URI.create("http://httpbin.org/image/jpeg"),
                URI.create("http://httpbin.org/image/png"),
                URI.create("http://httpbin.org/image/svg"));

        // Build requests for each URI and store them in a List
        List<HttpRequest> requestList = uriList.stream()
                .map(HttpRequest::newBuilder)
                .map(reqBuilder -> reqBuilder.build())
                .collect(toList());

        // Send all requests asynchronously and wait for them to finish
        CompletableFuture.allOf(
                requestList.stream()
                        .map(req -> {
                            String[] elems = 
                                    req.uri().getPath().split("/");
                            String fileName = 
                                    "image." + elems[elems.length - 1];
                            return client.sendAsync(req,
                                BodyHandlers.ofFile(Paths.get(fileName)));
                        }).toArray(CompletableFuture<?>[]::new)
        ).thenRun(() -> System.out.println("All downloads completed."))
         .join();
    }
}
