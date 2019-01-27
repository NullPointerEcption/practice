package demo3.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-01-25 13:44
 **/
public class EchoClientHandler extends ChannelInboundHandlerAdapter {


    private static final int REPEAT = 500;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < REPEAT; i++) {
            ctx.writeAndFlush("[" + i + "] client say hello " + System.lineSeparator());
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 只要服务器端发送完成信息之后都会执行此方法进行内容的输出操作
        try {
            System.out.println("client read msg : " + msg.toString().trim());
        } finally {
            //释放缓存
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
