// WebSocketEchoListener.java
package com.jdojo.http.client;

import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import static java.util.stream.Collectors.joining;

public final class WebSocketEchoListener implements WebSocket.Listener {
    // Partial text messages are accumulated in this list
    private final List<String> textMessages = new ArrayList<>();

    // This CompletableFuture is complete when an error occurs or the 
    // WebSocket is closed. See the onError() and onClose() methods.
    CompletableFuture<String> closeStatus = new CompletableFuture<>();

    @Override
    public void onOpen(WebSocket webSocket) {
        System.out.println("Connected...");

        // Request one more message
        webSocket.request(1);
    }

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, 
            CharSequence data, boolean last) {
        // Request one more message
        webSocket.request(1);

        // Accumulate the message
        textMessages.add(data.toString());
        
        if (last) {
            // Received the last part of the message. Let us print it.
            String wholeMessage = textMessages.stream()
                                              .collect(joining(""));
            System.out.println("Received: " + wholeMessage);

            // Clear the accumulated messages, so we can accumulate
            // partial messages received in future
            textMessages.clear();
        }

        // Return null to indicate that message proccessing is complete
        return null;
    }

    @Override
    public CompletionStage<?> onPong​(WebSocket webSocket, 
            ByteBuffer message) {
        // Request one more message
        webSocket.request(1);

        // Decode the message and print it
        String data = new String(message.array());
        System.out.println("Received a Pong: " + data);

        // Return null to indicate that message proccessing is complete
        return null;
    }

    @Override
    public void onError(WebSocket webSocket, Throwable error) {
        // Complete the CompletableFuture exceptionally to indicate that 
        // the WebSocket connection is closed with error
        closeStatus.completeExceptionally(error);
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket,
            int statusCode, String reason) {
         
        // Prepare the close description
        String closeDescription = "Closed with status " + statusCode
                + " and reason: " + reason;

        // Complete the CompletableFuture to indiate that the WebSocket
        // connection is closed
        closeStatus.complete(closeDescription);

        return null;
    }

    public CompletableFuture<String> closeStatus() {
        return this.closeStatus;
    }
}
