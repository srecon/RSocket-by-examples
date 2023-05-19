package rsocket;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.core.RSocketServer;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;

public class Server {
    public static void main(String[] args) {
        RSocketServer.create((setup, sendingSocket) -> Mono.just(
                        new RSocket() {
                            @Override
                            public Mono<Payload> requestResponse(Payload payload) {
                                System.out.println("Received: " + payload.getDataUtf8());
                                return Mono.just(DefaultPayload.create("Hello from server!"));
                            }
                        }))
                .bind(TcpServerTransport.create(7001))
                .block()
                .onClose()
                .block();
    }
}
