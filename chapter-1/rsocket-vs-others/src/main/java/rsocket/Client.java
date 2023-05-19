package rsocket;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;

public class Client {
    public static void main(String[] args) {
        RSocket socket = RSocketConnector.create()
                .connect(TcpClientTransport.create(7001))
                .block();

        Mono<Payload> response = socket.requestResponse(DefaultPayload.create("Hello from client!"));
        response.map(Payload::getDataUtf8).subscribe(System.out::println);

        socket.dispose();
    }
}