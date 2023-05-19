package websocket;

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WSServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        WebSocketHandler wsHandler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory factory) {
                factory.register(MyWebSocketHandler.class);
            }
        };
        ServletHolder holder = new ServletHolder("ws", new MyWebSocketServlet());
        context.addServlet(holder, "/*");

        server.start();
        server.join();
    }
    public static class MyWebSocketServlet extends org.eclipse.jetty.websocket.servlet.WebSocketServlet {
        @Override
        public void configure(WebSocketServletFactory factory) {
            factory.getPolicy().setIdleTimeout(10_000);
            factory.register(MyWebSocketHandler.class);
        }
    }

    @WebSocket
    public static class MyWebSocketHandler {
        @OnWebSocketConnect
        public void onConnect(Session session) {
            System.out.println("Connected: " + session.getRemoteAddress().getAddress());
        }

        @OnWebSocketMessage
        public void onMessage(Session session, String message) {
            System.out.println("Received: " + message);
            try {
                session.getRemote().sendString("Hello from server!");
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }

        @OnWebSocketClose
        public void onClose(Session session, int statusCode, String reason) {
            System.out.println("Closed: " + reason);
        }

        @OnWebSocketError
        public void onError(Session session, Throwable throwable) {
            System.out.println("Error: " + throwable.getMessage());
        }
    }
}

