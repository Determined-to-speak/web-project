package com.example.grpcmain;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rpcservice.ProductInfoImpl;

import java.io.IOException;

@SpringBootApplication
public class GrpcMainApplication {

    Server server;

    public static void main(String[] args) {
        SpringApplication.run(GrpcMainApplication.class, args);
        GrpcMainApplication server = new GrpcMainApplication();
        try {
            server.start();
            server.blockUntilShutdown();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        //8084 为grpc的启动端口
        int port = 8084;
        server = ServerBuilder.forPort(port)
                .addService(new ProductInfoImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            GrpcMainApplication.this.stop();
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

}
