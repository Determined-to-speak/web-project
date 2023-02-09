package com.example.grpcclient;

import com.google.protobuf.TextFormat;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import model.Product;
import model.ProductId;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rpcservice.ProductInfoGrpc;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class GrpcClientApplication {

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(GrpcClientApplication.class, args);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8084)
                .usePlaintext()
                .build();
        ProductInfoGrpc.ProductInfoBlockingStub stub = ProductInfoGrpc.newBlockingStub(channel);
        Product p = Product.newBuilder().setId("1")
                .setPrice(399.0f)
                .setName("grpc client端")
                .setDescription("调试grpc客户端保证项目正常运行")
                .build();
        ProductId productId = stub.addProduct(p);
        System.out.println("productId.getValue() = " + productId.getValue());
        Product product = stub.getProduct(ProductId.newBuilder().setValue("99999").build());
        System.out.println("product.toString() = " + product.toByteString().toStringUtf8());
    }

}
