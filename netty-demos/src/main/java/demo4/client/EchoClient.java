package demo4.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import unit.NettyDemoConstant;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-01-25 13:44
 **/
public class EchoClient {

    public void run() throws Exception {
        //创建工作线程池
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            ChannelFuture channelFuture = bootstrap.group(workerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(
                                    new FixedLengthFrameDecoder(100),
                                    new DelimiterBasedFrameDecoder(1024, NettyDemoConstant.SEPERATOR_BUF),
                                    new StringEncoder(CharsetUtil.UTF_8),
                                    new StringDecoder(CharsetUtil.UTF_8),
                                    new EchoClientHandler());
                        }
                    })
                    .connect("127.0.0.1", 8888).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }

    }
}
