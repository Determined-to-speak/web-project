package com.example.grpcclient.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Java Selector学习实例代码
 * <p>
 * Java中的NIO是看Tomcat的基础
 * <p>
 * <p>
 * 参考资料  https://zhuanlan.zhihu.com/p/27434028
 * <p>
 * 此处是 Client 端，具体的客户端在 network-main 中
 */
public class EpollClient {

    public static void main(String[] args) {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);

            writeBuffer.put("hello".getBytes());
            writeBuffer.flip();

            while (true) {
                writeBuffer.rewind();
                socketChannel.write(writeBuffer);
                readBuffer.clear();
                socketChannel.read(readBuffer);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
