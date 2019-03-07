package basedemos.demo1.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-03-05 21:28
 **/
public class EchoServerHandler2 extends SimpleChannelInboundHandler<HttpObject> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.out.println("receive from :" + ctx.channel().remoteAddress().toString());
        if (msg instanceof HttpRequest) {
            ByteBuf respdata = Unpooled.copiedBuffer("hello netty~".getBytes());
            DefaultHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, HttpResponseStatus.OK, respdata);
            resp.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN);
            resp.headers().set(HttpHeaderNames.CONTENT_LENGTH, respdata.readableBytes());
            ctx.writeAndFlush(resp);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("caught exception...");
        cause.printStackTrace();
        ctx.close();
    }
}
