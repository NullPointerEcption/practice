package basedemos.demo1.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.time.LocalDateTime;

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
            ByteBuf msgBuf = (ByteBuf) msg;
            System.out.println("Server Read Client msg :" + msgBuf.toString(CharsetUtil.UTF_8));
            ctx.writeAndFlush(Unpooled.buffer().writeBytes(("Server resp :" + LocalDateTime.now().toString()).getBytes()));
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
