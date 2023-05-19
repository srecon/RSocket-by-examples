package grpc;

import grpc.Hello;
import grpc.HelloOuterClass.HelloRequest;
import grpc.HelloOuterClass.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloRequest request = HelloRequest.newBuilder().setGreeting("Hello from client!").build();
        HelloResponse response = stub.sayHello(request);

        System.out.println(response.getReply());

        channel.shutdown();
    }
}

