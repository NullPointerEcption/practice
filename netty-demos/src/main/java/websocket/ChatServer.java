package websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-06 17:31
 **/
public class ChatServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            ChannelFuture channelFuture = serverBootstrap.group(mainGroup, subGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //websocket 基于http协议
                            pipeline.addLast(new HttpServerCodec())
                                    //大数据流写入支持
                                    .addLast(new ChunkedWriteHandler())
                                    //聚合器 对httpMsg进行聚合
                                    .addLast(new HttpObjectAggregator(1024 * 64))
                                    //--------------以上用于支持http协议----------------------------------
                                    //websocket 支持协议
                                    .addLast(new WebSocketServerProtocolHandler("/ws"))
                                    //自定义的handler 处理客户端消息
                                    .addLast(new ChatHandler())
                                    .addLast(new HeartBeatHanndler());

                        }
                    })
                    .bind(8888)
                    .sync();

            channelFuture.channel().closeFuture().sync();
        } finally {
            mainGroup.shutdownGracefully();
            subGroup.shutdownGracefully();
        }
    }
}
