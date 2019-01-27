package basedemos.demo5.server;

import basedemos.demo5.vo.Member;
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
        Member member = new Member();
        member.setId(100L);
        member.setEmail("123@qq.com");
        member.setName("wangyufei");
        ctx.writeAndFlush(member);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            Member member = (Member) msg;
            System.out.println("server receive msg:" + member);
            member.setName("[ECHO ]" + member.getName());
            ctx.writeAndFlush(member);
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
