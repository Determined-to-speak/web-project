package com.example.networkmain.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Java Selector学习实例代码
 * <p>
 * Java中的NIO是看Tomcat的基础
 * <p>
 * <p>
 * 参考资料  https://zhuanlan.zhihu.com/p/27434028
 * <p>
 * 此处是Server端，具体的客户端在grpc-client中
 */
public class EpollServer {

    public static void main(String[] args) {

        try {
            //region socket监听端口
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
            ssc.configureBlocking(false);
            //endregion

            //注册Channel，并指定感兴趣的事件是Accept
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            writeBuffer.put("received".getBytes());
            writeBuffer.flip();

            while (true) {
                //阻塞的找到已经准备进行IO操作的channel个数 ----- 我个人感觉就是为了防止无限的for循环
                int nReady = selector.select();

                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();

                    if (key.isAcceptable()) {

                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        //将新的连接注册到Selector上面
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } else if (key.isReadable()) {

                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        readBuffer.clear();
                        socketChannel.read(readBuffer);

                        readBuffer.flip();
                        System.out.println("received: " + new String(readBuffer.array()));
                        key.interestOps(SelectionKey.OP_WRITE);

                    } else if (key.isWritable()) {

                        writeBuffer.rewind();
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.write(writeBuffer);
                        key.interestOps(SelectionKey.OP_READ);

                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
