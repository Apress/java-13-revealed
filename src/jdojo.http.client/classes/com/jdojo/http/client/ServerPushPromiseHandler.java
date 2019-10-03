// ServerPushPromiseHandler.java
package com.jdojo.http.client;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import static java.lang.System.out;

public class ServerPushPromiseHandler implements
        HttpResponse.PushPromiseHandler<String> {
    @Override
    public void applyPushPromise(HttpRequest initiatingRequest,
            HttpRequest pushPromiseRequest,
            Function<HttpResponse.BodyHandler<String>, 
                    CompletableFuture<HttpResponse<String>>> acceptor) {

        // Print URIs of the push promise request and 
        // its initiating request
        out.printf("Received push promise request URI: %s%n"
                 + "Push promise initiating request URI: %s%n%n",
                 pushPromiseRequest.uri(),
                 initiatingRequest.uri());
        
        // Accept the push promise by calling the apply() method
        // on the function passed in to this method
        acceptor.apply(HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    // Print the push promise response details
                    out.printf("%nProcessed push promise request URI: %s%n"
                            + "Pushed response status code: %d%n",
                            pushPromiseRequest.uri(),
                            response.statusCode());
                });
    }
}
