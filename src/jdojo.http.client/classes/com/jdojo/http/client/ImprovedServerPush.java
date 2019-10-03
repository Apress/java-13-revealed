// ImprovedServerPush .java
package com.jdojo.http.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import static java.lang.System.out;

public class ImprovedServerPush {
    public static void main(String[] args) throws InterruptedException {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();
                
        // Build a request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://angular.io"))
                .build();

        // Create a concurrent map to accumulate all push promises
        ConcurrentMap<HttpRequest,CompletableFuture<HttpResponse<String>>> 
                pushPromisesMap  = new ConcurrentHashMap<>();

        // Create a push promise handler
        PushPromiseHandler<String> pushPromiseHandler
                = PushPromiseHandler.of(pushPromiseRequest -> {
                    out.printf("Received push promise request URI: %s%n"
                           + "Push promise initiating request URI: %s%n%n",
                            pushPromiseRequest.uri(),
                            request.uri());
                    return BodyHandlers.ofString();
                }, pushPromisesMap);

        // Send the request asynchronously allowing server push
        HttpResponse<String> response = client.sendAsync(request,
                BodyHandlers.ofString(),
                pushPromiseHandler
        ).join();

        // Print the response details
        out.printf("Initiating request URI: %s%n"
                + "Response's request URI: %s%n"
                + "Response status code: %d%n",
                request.uri(),
                response.request().uri(),
                response.statusCode());

        // By this time all push promises are in the pushPromisesMap.
        // Their responses might not have been available by now.
        CompletableFuture<?>[] allPushPromises
                = pushPromisesMap.values()
                        .toArray(CompletableFuture<?>[]::new);

        // Wait for all push promise response bodies be available
        CompletableFuture.allOf(allPushPromises)
                         .join();

        // Print the push promise response details
        pushPromisesMap.values()
                .stream()
                .map(CompletableFuture::join)
                .forEach(pushResponse -> {
                    out.printf("%nProcessed push promise request URI: %s%n"
                            + "Pushed response status code: %d%n",
                            pushResponse.request().uri(),
                            pushResponse.statusCode());
                });
    }
}
