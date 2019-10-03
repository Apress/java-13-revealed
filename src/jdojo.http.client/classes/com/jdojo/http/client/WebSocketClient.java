// WebSocketClient.java
package com.jdojo.http.client;

import static java.lang.System.out;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import static java.net.http.WebSocket.NORMAL_CLOSURE;
import java.nio.ByteBuffer;

public class WebSocketClient {
    public static void main(String[] args) throws InterruptedException {
        // Create an HttpClient with default configurations
        HttpClient client = HttpClient.newHttpClient();

        // Create a listener for our WebSocket
        WebSocketEchoListener listener = new WebSocketEchoListener();

        // Create a WebSocket
        WebSocket webSocket = client.newWebSocketBuilder()
                .buildAsync(URI.create("ws://demos.kaazing.com/echo"),
                        listener)
                .join();

        // Send a message to the server. The second argument of true
        // in the sendText() indicates that the message is whole.
        String helloMessage = "Hello, there.";
        webSocket.sendText(helloMessage, true)
                .thenRun(() -> out.println("Sent: " + helloMessage))
                .join();

        // Send a Ping message to the server
        String pingMessage = "Just checking...";
        webSocket.sendPing(ByteBuffer.wrap(pingMessage.getBytes()))
                .thenRun(() -> out.println("Sent Ping: " + pingMessage))
                .join();

        // Send a Close message to the server. After this, you cannot 
        // send any more messages to the server. The server will send 
        // you back a Close message.
        webSocket.sendClose(NORMAL_CLOSURE, "Done")
                .thenRun(() -> out.println("Sent Close"))
                .join();

        // Wait for the WebSocket listener to close. Recall that the 
        // CompletableFuture<String> returned from the closeStatus() 
        // method completes when the onClose() or onError() method of 
        // the listener is called.
        listener.closeStatus()
                .thenAccept(System.out::println)
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                })
                .join();
    }
}
