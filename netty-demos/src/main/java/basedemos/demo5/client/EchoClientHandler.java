package basedemos.demo5.client;

import basedemos.demo5.vo.Member;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-01-25 13:44
 **/
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("echoclientHandler register...");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 只要服务器端发送完成信息之后都会执行此方法进行内容的输出操作
        try {
            Member member = (Member) msg;
            System.out.println("client read msg : " + msg.toString().trim());
            ctx.writeAndFlush(Member.buildRandom());
            TimeUnit.SECONDS.sleep(5);
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
