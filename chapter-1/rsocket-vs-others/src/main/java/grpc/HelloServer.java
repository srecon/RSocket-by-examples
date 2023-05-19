package grpc;

import grpc.HelloGrpc;
import grpc.HelloOuterClass.HelloRequest;
import grpc.HelloOuterClass.HelloResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HelloServer {
    public static void main(String[] args) throws java.io.IOException, InterruptedException {
        io.grpc.Server server = io.grpc.ServerBuilder.forPort(8080)
                .addService(new HelloServiceImpl())
                .build()
                .start();

        System.out.println("Server started!");
        server.awaitTermination();
    }

    static class HelloServiceImpl extends HelloGrpc.HelloImplBase {
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
            System.out.println("Received: " + request.getGreeting());
            HelloResponse response = HelloResponse.newBuilder().setReply("Hello from server!").build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
