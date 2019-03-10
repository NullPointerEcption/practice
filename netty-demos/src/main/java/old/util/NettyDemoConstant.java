package old.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-01-27 16:22
 **/
public class NettyDemoConstant {
    /**
     * 自定义的分隔符
     */
    public static final String SEPERATOR = "&%&";

    public static final ByteBuf SEPERATOR_BUF = Unpooled.buffer().writeBytes(NettyDemoConstant.SEPERATOR.getBytes());
}
