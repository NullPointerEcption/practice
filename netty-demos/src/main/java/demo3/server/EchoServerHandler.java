package demo3.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * <p>
 * Description: ServerHandler 针对输入数据的处理
 * </p>
 *
 * @author WangYuFei
 * @date 2019-01-24 21:28
 **/
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.buffer().writeBytes("Server active".getBytes()));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            System.out.println("server receive msg:" + msg);
            ctx.writeAndFlush("[server echo] " + msg + System.lineSeparator());
        } finally {
            ReferenceCountUtil.release(msg);//释放缓存
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
