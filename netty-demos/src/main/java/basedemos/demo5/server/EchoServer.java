package basedemos.demo5.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * <p>
 * Description:使用字符串传输
 * </p>
 *
 * @author WangYuFei
 * @date 2019-01-24 21:28
 **/
public class EchoServer {

    public void run() throws Exception {
        //主线程池：负责接收客户端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(10);
        //工作线程池：负责处理客户端的连接
        EventLoopGroup workerGroup = new NioEventLoopGroup(20);

        try {
            System.out.println("服务器端启动成功");
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            ChannelFuture channelFuture = serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(
                                    new ObjectDecoder(ClassResolvers.cacheDisabled(this.getClass().getClassLoader())),
                                    new ObjectEncoder(),
                                    new EchoServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .bind(8888).sync();

            channelFuture.channel().closeFuture().sync();
            System.out.println("服务器端关闭成功");
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
