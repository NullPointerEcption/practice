package websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;

/**
 * <p>
 * Description:处理消息的Handler
 * TextWebSocketFrame 用于为websocket专门处理文本的对象
 * </p>
 *
 * @author WangYuFei
 * @date 2019-03-06 17:53
 **/
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    public static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        String msgReceived = msg.text();
        // 接收到消息 并发送给所有的客户端
        clients.writeAndFlush(" i am server ，now time is " + LocalDateTime.now().toString());

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
        System.out.println("add a channel,now size is : " + clients.size());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //当该方法被调用时会自动移除
        //clients.remove(ctx.channel));
        System.out.println("removed a channel,now size is : " + clients.size());
        System.out.println("removed channel long id :" + ctx.channel().id().asLongText());
        System.out.println("removed channel short id :" + ctx.channel().id().asShortText());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
        clients.remove(ctx.channel());
    }
}
