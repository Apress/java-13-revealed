// HttpPushPromiseHandler.java
package com.jdojo.http.client;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class HttpPushPromiseHandler implements
        HttpResponse.PushPromiseHandler<String> {
    @Override
    public void applyPushPromise(HttpRequest initiatingRequest,
            HttpRequest pushPromiseRequest,            
            Function<HttpResponse.BodyHandler<String>,
                    CompletableFuture<HttpResponse<String>>> acceptor) {

        // Accept the push promise by calling the apply() method
        // on the function passed in to this method
        acceptor.apply(HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    int statusCode = response.statusCode();
                    String body = response.body();
                    System.out.println("Pushed response statuc code: "
                            + statusCode);
                    /* Do something with the response body here */
                });

        System.out.println("Push promise request URI: "
                + pushPromiseRequest.uri());
    }
}
