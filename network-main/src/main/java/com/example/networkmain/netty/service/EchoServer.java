package com.example.networkmain.netty.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;

/**
 * @author lizhijiangjiang
 * @version 1.0
 * @description: TODO
 * @date 2023/2/14 9:45
 */

@Service("EchoServer")
public class EchoServer {

    // 服务器端口
    @Value("${server.port}")
    private int port;
    // 通过nio方式来接收连接和处理连接
    private static EventLoopGroup boss = new NioEventLoopGroup();
    private static EventLoopGroup work = new NioEventLoopGroup();

    // 启动引导器
    private static ServerBootstrap b = new ServerBootstrap();

    @Autowired
    private EchoServerHandler echoServerHandler;

    public void run() {
        try {
            b.group(boss, work);
            b.channel(NioServerSocketChannel.class);
            b.localAddress(new InetSocketAddress(port));
            //设置通道初始化
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                //有连接到达时会创建一个channel
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    //pipeline管理channel中的Handler
                    //在channel队列中添加一个handler来处理业务

                    //这里特别注意，看源码，所有数据的入栈出栈逻辑都是在这里(初始化)写的
                    //但是入栈是按从上到下的Handler 出栈是按从下到上的Handler
                    ch.pipeline().addLast("echoServerHandler", echoServerHandler);
                }
            });

            // 配置完成，开始绑定server
            // 通过调用sync同步方法阻塞直到绑定成功
            ChannelFuture f = b.bind().sync();
            System.out.println(EchoServer.class.getName() +
                    " started and listen on " + f.channel().localAddress());

            // 监听服务器关闭事件
            // 应用程序会一直等待，直到channel关闭
            f.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //关闭EventLoopGroup，释放掉所有资源包括创建的线程
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }


}
