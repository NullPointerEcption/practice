package websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @description:监听客户端下线
 * @author: WangYuFei
 * @create: 2019-03-08 19:09
 **/
public class HeartBeatHanndler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        Channel channel = ctx.channel();
        if(evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;

            if(idleStateEvent.state() == IdleState.READER_IDLE){
                System.out.println("channel "+ channel.id().asShortText() +" 处于读空闲");
            }
            else if(idleStateEvent.state() == IdleState.WRITER_IDLE){
                System.out.println("channel "+ channel.id().asShortText() +" 处于写空闲");
            }
            else if(idleStateEvent.state() == IdleState.ALL_IDLE){
                System.out.println(ChatHandler.clients.size());
                System.out.println("channel "+ channel.id().asShortText() +" 处于读写空闲");
                channel.close();
                System.out.println(ChatHandler.clients.size());
            }
        }
    }
}
