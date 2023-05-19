package websocket;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WSClient {
    public static void main(String[] args) {
        URI uri = URI.create("ws://localhost:9000/");
        WebSocketClient client = new WebSocketClient();
        MyWebSocket socket = new MyWebSocket();

        try {
            client.start();
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            Future<Session> future = client.connect(socket, uri, request);
            Session session = future.get(5, TimeUnit.SECONDS);

            session.getRemote().sendString("Hello from client!");

            Thread.sleep(5000);
            session.close();

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @WebSocket
    public static class MyWebSocket {
        @OnWebSocketMessage
        public void onMessage(String message) {
            System.out.println("Received: " + message);
        }

        @OnWebSocketClose
        public void onClose(int statusCode, String reason) {
            System.out.println("Closed: " + reason);
        }

        @OnWebSocketError
        public void onError(Throwable throwable) {
            System.out.println("Error: " + throwable.getMessage());
        }
    }
}
