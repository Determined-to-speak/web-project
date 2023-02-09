package rpcservice;

import com.google.protobuf.TextFormat;
import model.Product;
import model.ProductId;

import java.nio.charset.StandardCharsets;

/**
 * @author lizhijiangjiang
 * @version 1.0
 * @description: TODO
 * @date 2023/2/9 15:09
 */
public class ProductInfoImpl extends ProductInfoGrpc.ProductInfoImplBase {


    /**
     * @param request          product对象
     * @param responseObserver 当前方法的返回结果
     */
    @Override
    public void addProduct(Product request,
                           io.grpc.stub.StreamObserver<ProductId> responseObserver) {
        System.out.println("request.toString() = " + request.toByteString().toStringUtf8());
        responseObserver.onNext(ProductId.newBuilder().setValue(request.getId()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(ProductId request,
                           io.grpc.stub.StreamObserver<Product> responseObserver) {
        responseObserver.onNext(Product.newBuilder().setId(request.getValue()).setName("三国演义").build());
        responseObserver.onCompleted();
    }

}
